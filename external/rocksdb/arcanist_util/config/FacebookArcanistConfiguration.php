<?php
// Copyright 2004-present Facebook. All Rights Reserved.
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

<<<<<<< HEAD
class FacebookArcanistConfiguration extends ArcanistConfiguration {

  public function didRunWorkflow($command,
                                 ArcanistBaseWorkflow $workflow,
                                 $error_code) {
    if ($command == 'diff' && !$workflow->isRawDiffSource()) {
      $this->maybePushToJenkins($workflow);
    }
  }

  //////////////////////////////////////////////////////////////////////
  /* Send off builds to jenkins */
  function maybePushToJenkins($workflow) {
    $diffID = $workflow->getDiffID();
    if ($diffID === null) {
      return;
    }

    $results = $workflow->getTestResults();
    if (!$results) {
      return;
    }

    $url = "https://ci-builds.fb.com/view/rocksdb/job/rocksdb_diff_check/"
               ."buildWithParameters?token=AUTH&DIFF_ID=$diffID";
    system("curl --noproxy '*' \"$url\" > /dev/null 2>&1");
  }

=======
require('RocksDBCommonHelper.php');

define("DIFF_COMMAND", "diff");

class FacebookArcanistConfiguration extends ArcanistConfiguration {

  public function didRunWorkflow($command,
                                 ArcanistWorkflow $workflow,
                                 $error_code) {
    // Default options don't terminate on failure, but that's what we want. In
    // the current case we use assertions intentionally as "terminate on failure
    // invariants".
    assert_options(ASSERT_BAIL, true);

    assert($workflow);
    assert(strlen($command) > 0);

    if ($command == DIFF_COMMAND && !$workflow->isRawDiffSource()) {
      $diffID = $workflow->getDiffId();

      // When submitting a diff this code path gets executed multiple times in
      // a row. We only care about the case when ID for the diff is provided
      // because that's what we need to apply the diff and trigger the tests.
      if (strlen($diffID) > 0) {
        assert(is_numeric($diffID));
        startTestsInSandcastle(true /* $applyDiff */, $workflow, $diffID);
      }
    }
  }
>>>>>>> forknote/master
}
