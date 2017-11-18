<<<<<<< HEAD
// Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.
package org.rocksdb;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.rocksdb.util.Environment;

<<<<<<< HEAD
=======
import java.io.File;
>>>>>>> forknote/master
import java.io.IOException;
import java.nio.file.*;

import static org.assertj.core.api.Assertions.assertThat;

public class NativeLibraryLoaderTest {

  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Test
  public void tempFolder() throws IOException {
<<<<<<< HEAD
    NativeLibraryLoader.getInstance().loadLibraryFromJar(
        temporaryFolder.getRoot().getAbsolutePath());
    Path path = Paths.get(temporaryFolder.getRoot().getAbsolutePath(),
=======
    NativeLibraryLoader.getInstance().loadLibraryFromJarToTemp(
        temporaryFolder.getRoot().getAbsolutePath());
    final Path path = Paths.get(temporaryFolder.getRoot().getAbsolutePath(),
>>>>>>> forknote/master
        Environment.getJniLibraryFileName("rocksdb"));
    assertThat(Files.exists(path)).isTrue();
    assertThat(Files.isReadable(path)).isTrue();
  }
<<<<<<< HEAD
=======

  @Test
  public void overridesExistingLibrary() throws IOException {
    File first = NativeLibraryLoader.getInstance().loadLibraryFromJarToTemp(
        temporaryFolder.getRoot().getAbsolutePath());
    NativeLibraryLoader.getInstance().loadLibraryFromJarToTemp(
        temporaryFolder.getRoot().getAbsolutePath());
    assertThat(first.exists()).isTrue();
  }
>>>>>>> forknote/master
}
