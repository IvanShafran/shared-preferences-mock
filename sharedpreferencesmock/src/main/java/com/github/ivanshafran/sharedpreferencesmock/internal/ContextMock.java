package com.github.ivanshafran.sharedpreferencesmock.internal;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.Display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Executor;

@SuppressLint("WrongConstant")
public class ContextMock extends Context {

    @Override
    public SharedPreferences getSharedPreferences(final String name, final int mode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deleteSharedPreferences(final String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean moveSharedPreferencesFrom(final Context sourceContext, final String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AssetManager getAssets() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Resources getResources() {
        throw new UnsupportedOperationException();
    }

    @Override
    public PackageManager getPackageManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ContentResolver getContentResolver() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Looper getMainLooper() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Context getApplicationContext() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTheme(final int resid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Resources.Theme getTheme() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ClassLoader getClassLoader() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getPackageName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getPackageResourcePath() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getPackageCodePath() {
        throw new UnsupportedOperationException();
    }

    @Override
    public FileInputStream openFileInput(final String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FileOutputStream openFileOutput(final String name, final int mode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deleteFile(final String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getFileStreamPath(final String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getDataDir() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getFilesDir() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getNoBackupFilesDir() {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Override
    public File getExternalFilesDir(@Nullable final String type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public File[] getExternalFilesDirs(final String type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getObbDir() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File[] getObbDirs() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getCacheDir() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getCodeCacheDir() {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Override
    public File getExternalCacheDir() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File[] getExternalCacheDirs() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File[] getExternalMediaDirs() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String[] fileList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getDir(final String name, final int mode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(
            final String name,
            final int mode,
            final SQLiteDatabase.CursorFactory factory
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(
            final String name,
            final int mode,
            final SQLiteDatabase.CursorFactory factory,
            @Nullable final DatabaseErrorHandler errorHandler
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean moveDatabaseFrom(final Context sourceContext, final String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deleteDatabase(final String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public File getDatabasePath(final String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String[] databaseList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Drawable getWallpaper() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Drawable peekWallpaper() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getWallpaperDesiredMinimumWidth() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getWallpaperDesiredMinimumHeight() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setWallpaper(final Bitmap bitmap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setWallpaper(final InputStream data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearWallpaper() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startActivity(final Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startActivity(final Intent intent, @Nullable final Bundle options) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startActivities(final Intent[] intents) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startActivities(final Intent[] intents, final Bundle options) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startIntentSender(
            final IntentSender intent,
            @Nullable final Intent fillInIntent,
            final int flagsMask,
            final int flagsValues,
            final int extraFlags
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void startIntentSender(
            final IntentSender intent,
            @Nullable final Intent fillInIntent,
            final int flagsMask,
            final int flagsValues,
            final int extraFlags,
            @Nullable final Bundle options
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendBroadcast(final Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendBroadcast(final Intent intent, @Nullable final String receiverPermission) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendOrderedBroadcast(final Intent intent, @Nullable final String receiverPermission) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendOrderedBroadcast(
            @NonNull final Intent intent,
            @Nullable final String receiverPermission,
            @Nullable final BroadcastReceiver resultReceiver,
            @Nullable final Handler scheduler,
            final int initialCode,
            @Nullable final String initialData,
            @Nullable final Bundle initialExtras
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendBroadcastAsUser(final Intent intent, final UserHandle user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendBroadcastAsUser(
            final Intent intent,
            final UserHandle user,
            @Nullable final String receiverPermission
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendOrderedBroadcastAsUser(
            final Intent intent,
            final UserHandle user,
            @Nullable final String receiverPermission,
            final BroadcastReceiver resultReceiver,
            @Nullable final Handler scheduler,
            final int initialCode,
            @Nullable final String initialData,
            @Nullable final Bundle initialExtras
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendStickyBroadcast(final Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendStickyOrderedBroadcast(
            final Intent intent,
            final BroadcastReceiver resultReceiver,
            @Nullable final Handler scheduler,
            final int initialCode,
            @Nullable final String initialData,
            @Nullable final Bundle initialExtras
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeStickyBroadcast(final Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendStickyBroadcastAsUser(final Intent intent, final UserHandle user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendStickyOrderedBroadcastAsUser(
            final Intent intent,
            final UserHandle user,
            final BroadcastReceiver resultReceiver,
            @Nullable final Handler scheduler,
            final int initialCode,
            @Nullable final String initialData,
            @Nullable final Bundle initialExtras
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeStickyBroadcastAsUser(final Intent intent, final UserHandle user) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Override
    public Intent registerReceiver(@Nullable final BroadcastReceiver receiver, final IntentFilter filter) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Override
    public Intent registerReceiver(
            @Nullable final BroadcastReceiver receiver,
            final IntentFilter filter,
            final int flags
    ) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Override
    public Intent registerReceiver(
            final BroadcastReceiver receiver,
            final IntentFilter filter,
            @Nullable final String broadcastPermission,
            @Nullable final Handler scheduler
    ) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Override
    public Intent registerReceiver(
            final BroadcastReceiver receiver,
            final IntentFilter filter,
            @Nullable final String broadcastPermission,
            @Nullable final Handler scheduler,
            final int flags
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregisterReceiver(final BroadcastReceiver receiver) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Override
    public ComponentName startService(final Intent service) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Override
    public ComponentName startForegroundService(final Intent service) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean stopService(final Intent service) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean bindService(final Intent service, @NonNull final ServiceConnection conn, final int flags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unbindService(@NonNull final ServiceConnection conn) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean startInstrumentation(
            @NonNull final ComponentName className,
            @Nullable final String profileFile,
            @Nullable final Bundle arguments
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getSystemService(@NonNull final String name) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    @Override
    public String getSystemServiceName(@NonNull final Class<?> serviceClass) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int checkPermission(@NonNull final String permission, final int pid, final int uid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int checkCallingPermission(@NonNull final String permission) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int checkCallingOrSelfPermission(@NonNull final String permission) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int checkSelfPermission(@NonNull final String permission) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enforcePermission(
            @NonNull final String permission,
            final int pid,
            final int uid,
            @Nullable final String message
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enforceCallingPermission(@NonNull final String permission, @Nullable final String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enforceCallingOrSelfPermission(@NonNull final String permission, @Nullable final String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void grantUriPermission(final String toPackage, final Uri uri, final int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void revokeUriPermission(final Uri uri, final int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void revokeUriPermission(final String toPackage, final Uri uri, final int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int checkUriPermission(final Uri uri, final int pid, final int uid, final int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int checkCallingUriPermission(final Uri uri, final int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int checkCallingOrSelfUriPermission(final Uri uri, final int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int checkUriPermission(
            @Nullable final Uri uri,
            @Nullable final String readPermission,
            @Nullable final String writePermission,
            final int pid,
            final int uid,
            final int modeFlags
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enforceUriPermission(
            final Uri uri,
            final int pid,
            final int uid,
            final int modeFlags,
            final String message
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enforceCallingUriPermission(final Uri uri, final int modeFlags, final String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enforceCallingOrSelfUriPermission(final Uri uri, final int modeFlags, final String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enforceUriPermission(
            @Nullable final Uri uri,
            @Nullable final String readPermission,
            @Nullable final String writePermission,
            final int pid,
            final int uid,
            final int modeFlags,
            @Nullable final String message
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Context createPackageContext(final String packageName, final int flags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Context createContextForSplit(final String splitName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Context createConfigurationContext(@NonNull final Configuration overrideConfiguration) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Context createDisplayContext(@NonNull final Display display) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Context createDeviceProtectedStorageContext() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDeviceProtectedStorage() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isRestricted() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Executor getMainExecutor() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerComponentCallbacks(final ComponentCallbacks callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregisterComponentCallbacks(final ComponentCallbacks callback) {
        throw new UnsupportedOperationException();
    }
}
