package org.rocksdb.util;

public class Environment {
  private static String OS = System.getProperty("os.name").toLowerCase();
  private static String ARCH = System.getProperty("os.arch").toLowerCase();

  public static boolean isWindows() {
    return (OS.contains("win"));
  }

  public static boolean isMac() {
    return (OS.contains("mac"));
  }

  public static boolean isUnix() {
    return (OS.contains("nix") ||
        OS.contains("nux") ||
        OS.contains("aix"));
  }

<<<<<<< HEAD
=======
  public static boolean isSolaris() {
     return OS.contains("sunos");
  }

>>>>>>> forknote/master
  public static boolean is64Bit() {
    return (ARCH.indexOf("64") > 0);
  }

  public static String getSharedLibraryName(final String name) {
    return name + "jni";
  }

  public static String getSharedLibraryFileName(final String name) {
    return appendLibOsSuffix("lib" + getSharedLibraryName(name), true);
  }

  public static String getJniLibraryName(final String name) {
    if (isUnix()) {
      final String arch = (is64Bit()) ? "64" : "32";
      return String.format("%sjni-linux%s", name, arch);
    } else if (isMac()) {
      return String.format("%sjni-osx", name);
<<<<<<< HEAD
=======
    } else if (isSolaris()) {
      return String.format("%sjni-solaris%d", name, is64Bit() ? 64 : 32);
    } else if (isWindows() && is64Bit()) {
      return String.format("%sjni-win64", name);
>>>>>>> forknote/master
    }
    throw new UnsupportedOperationException();
  }

  public static String getJniLibraryFileName(final String name) {
    return appendLibOsSuffix("lib" + getJniLibraryName(name), false);
  }

  private static String appendLibOsSuffix(final String libraryFileName, final boolean shared) {
<<<<<<< HEAD
    if (isUnix()) {
      return libraryFileName + ".so";
    } else if (isMac()) {
      return libraryFileName + (shared ? ".dylib" : ".jnilib");
=======
    if (isUnix() || isSolaris()) {
      return libraryFileName + ".so";
    } else if (isMac()) {
      return libraryFileName + (shared ? ".dylib" : ".jnilib");
    } else if (isWindows()) {
      return libraryFileName + ".dll";
>>>>>>> forknote/master
    }
    throw new UnsupportedOperationException();
  }

  public static String getJniLibraryExtension() {
<<<<<<< HEAD
=======
    if (isWindows()) {
      return ".dll";
    }
>>>>>>> forknote/master
    return (isMac()) ? ".jnilib" : ".so";
  }
}
