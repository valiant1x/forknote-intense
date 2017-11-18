<<<<<<< HEAD
//  Copyright (c) 2014, Facebook, Inc.  All rights reserved.
=======
//  Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
//  This source code is licensed under the BSD-style license found in the
//  LICENSE file in the root directory of this source tree. An additional grant
//  of patent rights can be found in the PATENTS file in the same directory.

#include "util/sync_point.h"
<<<<<<< HEAD
=======
#include <thread>
>>>>>>> forknote/master
#include "port/port.h"
#include "util/random.h"

int rocksdb_kill_odds = 0;
<<<<<<< HEAD
=======
std::vector<std::string> rocksdb_kill_prefix_blacklist;
>>>>>>> forknote/master

#ifndef NDEBUG
namespace rocksdb {

<<<<<<< HEAD
void TestKillRandom(int odds, const std::string& srcfile, int srcline) {
  time_t curtime = time(nullptr);
  Random r((uint32_t)curtime);

  assert(odds > 0);
  bool crash = r.OneIn(odds);
=======
void TestKillRandom(std::string kill_point, int odds,
                    const std::string& srcfile, int srcline) {
  for (auto& p : rocksdb_kill_prefix_blacklist) {
    if (kill_point.substr(0, p.length()) == p) {
      return;
    }
  }

  assert(odds > 0);
  if (odds % 7 == 0) {
    // class Random uses multiplier 16807, which is 7^5. If odds are
    // multiplier of 7, there might be limited values generated.
    odds++;
  }
  auto* r = Random::GetTLSInstance();
  bool crash = r->OneIn(odds);
>>>>>>> forknote/master
  if (crash) {
    port::Crash(srcfile, srcline);
  }
}

SyncPoint* SyncPoint::GetInstance() {
  static SyncPoint sync_point;
  return &sync_point;
}

<<<<<<< HEAD
void SyncPoint::LoadDependency(const std::vector<Dependency>& dependencies) {
=======
void SyncPoint::LoadDependency(const std::vector<SyncPointPair>& dependencies) {
  std::unique_lock<std::mutex> lock(mutex_);
  successors_.clear();
  predecessors_.clear();
  cleared_points_.clear();
  for (const auto& dependency : dependencies) {
    successors_[dependency.predecessor].push_back(dependency.successor);
    predecessors_[dependency.successor].push_back(dependency.predecessor);
  }
  cv_.notify_all();
}

void SyncPoint::LoadDependencyAndMarkers(
    const std::vector<SyncPointPair>& dependencies,
    const std::vector<SyncPointPair>& markers) {
>>>>>>> forknote/master
  std::unique_lock<std::mutex> lock(mutex_);
  successors_.clear();
  predecessors_.clear();
  cleared_points_.clear();
<<<<<<< HEAD
=======
  markers_.clear();
  marked_thread_id_.clear();
>>>>>>> forknote/master
  for (const auto& dependency : dependencies) {
    successors_[dependency.predecessor].push_back(dependency.successor);
    predecessors_[dependency.successor].push_back(dependency.predecessor);
  }
<<<<<<< HEAD
=======
  for (const auto& marker : markers) {
    successors_[marker.predecessor].push_back(marker.successor);
    predecessors_[marker.successor].push_back(marker.predecessor);
    markers_[marker.predecessor].push_back(marker.successor);
  }
>>>>>>> forknote/master
  cv_.notify_all();
}

bool SyncPoint::PredecessorsAllCleared(const std::string& point) {
  for (const auto& pred : predecessors_[point]) {
    if (cleared_points_.count(pred) == 0) {
      return false;
    }
  }
  return true;
}

void SyncPoint::SetCallBack(const std::string point,
                            std::function<void(void*)> callback) {
  std::unique_lock<std::mutex> lock(mutex_);
  callbacks_[point] = callback;
}

void SyncPoint::ClearAllCallBacks() {
  std::unique_lock<std::mutex> lock(mutex_);
  while (num_callbacks_running_ > 0) {
    cv_.wait(lock);
  }
  callbacks_.clear();
}

void SyncPoint::EnableProcessing() {
  std::unique_lock<std::mutex> lock(mutex_);
  enabled_ = true;
}

void SyncPoint::DisableProcessing() {
  std::unique_lock<std::mutex> lock(mutex_);
  enabled_ = false;
}

void SyncPoint::ClearTrace() {
  std::unique_lock<std::mutex> lock(mutex_);
  cleared_points_.clear();
}

<<<<<<< HEAD
void SyncPoint::Process(const std::string& point, void* cb_arg) {
  std::unique_lock<std::mutex> lock(mutex_);

  if (!enabled_) return;
=======
bool SyncPoint::DisabledByMarker(const std::string& point,
                                 std::thread::id thread_id) {
  auto marked_point_iter = marked_thread_id_.find(point);
  return marked_point_iter != marked_thread_id_.end() &&
         thread_id != marked_point_iter->second;
}

void SyncPoint::Process(const std::string& point, void* cb_arg) {
  std::unique_lock<std::mutex> lock(mutex_);
  auto thread_id = std::this_thread::get_id();

  auto marker_iter = markers_.find(point);
  if (marker_iter != markers_.end()) {
    for (auto marked_point : marker_iter->second) {
      marked_thread_id_.insert(std::make_pair(marked_point, thread_id));
    }
  }

  if (DisabledByMarker(point, thread_id)) {
    return;
  }

  if (!enabled_) {
    return;
  }

  while (!PredecessorsAllCleared(point)) {
    cv_.wait(lock);
    if (DisabledByMarker(point, thread_id)) {
      return;
    }
  }
>>>>>>> forknote/master

  auto callback_pair = callbacks_.find(point);
  if (callback_pair != callbacks_.end()) {
    num_callbacks_running_++;
    mutex_.unlock();
    callback_pair->second(cb_arg);
    mutex_.lock();
    num_callbacks_running_--;
    cv_.notify_all();
  }

<<<<<<< HEAD
  while (!PredecessorsAllCleared(point)) {
    cv_.wait(lock);
  }

=======
>>>>>>> forknote/master
  cleared_points_.insert(point);
  cv_.notify_all();
}
}  // namespace rocksdb
#endif  // NDEBUG
