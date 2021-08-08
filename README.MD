# Shared Preferences Mock
[![Build Status](https://api.travis-ci.com/IvanShafran/shared-preferences-mock.svg?branch=master)](https://travis-ci.com/IvanShafran/shared-preferences-mock)
[![codecov](https://codecov.io/gh/IvanShafran/shared-preferences-mock/branch/master/graph/badge.svg)](https://codecov.io/gh/IvanShafran/shared-preferences-mock)
[![](https://jitpack.io/v/IvanShafran/shared-preferences-mock.svg)](https://jitpack.io/#IvanShafran/shared-preferences-mock)

Shared preferences mock is the lightweight library let you increase coverage of unit tests and simplify code for them with one line of code.

## Motivation

Unit test on Android uses a framework mock where every method throws `UnsupportedOperationException` or does nothing depending on your settings in Gradle `testOptions`. 

In unit tests, we mostly test business logic, which often depends on preferences. Therefore you should mock all classes which use `SharedPreferences` inside. It is a lot of boilerplate in tests. Moreover, because of this limitation, we never test preferences class code. However, it also may have bugs.

## Under the hood

Under the hood the library implements `SharedPreferences`, `Context.getSharedPreferences` and `Context.deleteSharedPreferences` in memory using only Java API. Check the differences in the differences paragraph.

## Download

Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency:

```groovy
dependencies {
    testImplementation 'com.github.IvanShafran:shared-preferences-mock:1.1'
}
```

Enable 1.8 Java compile option if it's not enabled yet:

```groovy
android {
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
```

## Release notes

<details><summary><b>Click to see release notes</b></summary>


<b>Version 1.1</b>
    
* Android X support. Thanks to [Neal Sanche](https://github.com/nealsanche)

<b>Version 1.0</b>

* First release

</details>

## Usage


In most cases, preference class or preference utils depends on `Context`. In unit test instead of real `Context` pass `Context` created by `new SPMockBuilder().createContext()`.

If you already have `Context` with some mocked methods, you can use `new SPMockBuilder().wrapContext(preconfiguredContext)`.

If you need raw `SharedPreferences` use `new SPMockBuilder().createSharedPreferences()`.

If thread safety is necessary for your test, then configure `SPMockBuilder.setThreadSafe(true)` . It is false by default.

## Sample

Full sample code in sample folder. Simplified version is below:

```java
public class CounterPreferences {
    // ...
    private final SharedPreferences sharedPreferences;
    public CounterPreferences(@NonNull final Context context) {
        sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
    }

    public int getCounter() {
        return sharedPreferences.getInt(KEY, 0);
    }
    // ...
}

public class ShowMessageLogic {
    // ...
    public boolean shouldShowMessage() {
        return counterPreferences.getCounter() >= 42;
    }
}

public class ShowMessageLogicTest {

    private final SPMockBuilder spMockBuilder = new SPMockBuilder();
    private CounterPreferences counterPreferences;
    private ShowMessageLogic showMessageLogic;

    @Before
    public void setUp() {
        counterPreferences = new CounterPreferences(spMockBuilder.createContext());
        showMessageLogic = new ShowMessageLogic(counterPreferences);
    }

    @Test
    public void on42CounterItShouldShowMessage() {
        counterPreferences.setCounter(42);
        Assert.assertTrue(showMessageLogic.shouldShowMessage());
    }

    @Test
    public void onLessThan42ItShouldNotShowMessage() {
        counterPreferences.setCounter(41);
        Assert.assertFalse(showMessageLogic.shouldShowMessage());
    }
}
```

### Alternatives

1. Create `CounterPreferences` interface and implement Java version for test by yourself

- Doesn't test `CounterPreferences` implementation
- Requires boilerplate code in tests

2. Use [Mockito](https://github.com/mockito/mockito)

- Doesn't test `CounterPreferences` implementation

3. Use [Robolectric](https://github.com/robolectric/robolectric)
- Has test startup delay for a few seconds

4. Use instrumented test(not a unit test!)
- Requires device for testing

## Differences from Android implementation


|                            | Android                                                                        | Library mock                                                          |
|:--------------------------:|--------------------------------------------------------------------------------|-----------------------------------------------------------------------|
| Can be used in unit tests? | No.                                                                            | Yes.                                                                  |
| Where it stores data?      | In memory and on disk.                                                         | In memory.                                                            |
| Does it have a global state? | Yes, it synchronizes via files. It is one of the main features.       | No, it is better for unit tests.                                      |
| Does API synchronous?      | Yes, but some methods schedule asynchronous operations.  For example: `apply`. | All methods are synchronous and are performed immediately.            |
| Is it thread safe?         | Yes.                                                                           | No by default, because unit tests should be fast as possible for CI. You can enable it with `setThreadSafety(true)` in `SPMockBuilder`.|
| Where are listeners called? | Main thread | Thread on which `apply` or `commit` are called |
| Does it follow docs?       | Partly no. `SharedPreferencesImpl` differs from docs in not the most important cases. | Library mimics `SharedPreferencesImpl` differences from docs.|

## License
```
MIT License

Copyright (c) 2019 Ivan Shafran

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
