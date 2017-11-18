<<<<<<< HEAD
//  Copyright (c) 2013, Facebook, Inc.  All rights reserved.
=======
//  Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
>>>>>>> forknote/master
//  This source code is licensed under the BSD-style license found in the
//  LICENSE file in the root directory of this source tree. An additional grant
//  of patent rights can be found in the PATENTS file in the same directory.
//
// Copyright (c) 2011 The LevelDB Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file. See the AUTHORS file for names of contributors.

<<<<<<< HEAD
#include "util/histogram.h"

#include <cassert>
#include <math.h>
#include <stdio.h>
=======
#ifndef __STDC_FORMAT_MACROS
#define __STDC_FORMAT_MACROS
#endif

#include <inttypes.h>
#include <cassert>
#include <math.h>
#include <stdio.h>
#include "util/histogram.h"
>>>>>>> forknote/master
#include "port/port.h"

namespace rocksdb {

HistogramBucketMapper::HistogramBucketMapper()
    :
      // Add newer bucket index here.
      // Should be always added in sorted order.
      // If you change this, you also need to change
      // size of array buckets_ in HistogramImpl
      bucketValues_(
          {1,         2,         3,         4,         5,         6,
           7,         8,         9,         10,        12,        14,
           16,        18,        20,        25,        30,        35,
           40,        45,        50,        60,        70,        80,
           90,        100,       120,       140,       160,       180,
           200,       250,       300,       350,       400,       450,
           500,       600,       700,       800,       900,       1000,
           1200,      1400,      1600,      1800,      2000,      2500,
           3000,      3500,      4000,      4500,      5000,      6000,
           7000,      8000,      9000,      10000,     12000,     14000,
           16000,     18000,     20000,     25000,     30000,     35000,
           40000,     45000,     50000,     60000,     70000,     80000,
           90000,     100000,    120000,    140000,    160000,    180000,
           200000,    250000,    300000,    350000,    400000,    450000,
           500000,    600000,    700000,    800000,    900000,    1000000,
           1200000,   1400000,   1600000,   1800000,   2000000,   2500000,
           3000000,   3500000,   4000000,   4500000,   5000000,   6000000,
           7000000,   8000000,   9000000,   10000000,  12000000,  14000000,
           16000000,  18000000,  20000000,  25000000,  30000000,  35000000,
           40000000,  45000000,  50000000,  60000000,  70000000,  80000000,
           90000000,  100000000, 120000000, 140000000, 160000000, 180000000,
           200000000, 250000000, 300000000, 350000000, 400000000, 450000000,
           500000000, 600000000, 700000000, 800000000, 900000000, 1000000000}),
      maxBucketValue_(bucketValues_.back()),
      minBucketValue_(bucketValues_.front()) {
  for (size_t i =0; i < bucketValues_.size(); ++i) {
    valueIndexMap_[bucketValues_[i]] = i;
  }
}

size_t HistogramBucketMapper::IndexForValue(const uint64_t value) const {
  if (value >= maxBucketValue_) {
    return bucketValues_.size() - 1;
  } else if ( value >= minBucketValue_ ) {
    std::map<uint64_t, uint64_t>::const_iterator lowerBound =
      valueIndexMap_.lower_bound(value);
    if (lowerBound != valueIndexMap_.end()) {
      return static_cast<size_t>(lowerBound->second);
    } else {
      return 0;
    }
  } else {
    return 0;
  }
}

namespace {
  const HistogramBucketMapper bucketMapper;
}

<<<<<<< HEAD
void HistogramImpl::Clear() {
  min_ = bucketMapper.LastValue();
  max_ = 0;
  num_ = 0;
  sum_ = 0;
  sum_squares_ = 0;
  memset(buckets_, 0, sizeof buckets_);
}

bool HistogramImpl::Empty() { return sum_squares_ == 0; }

void HistogramImpl::Add(uint64_t value) {
  const size_t index = bucketMapper.IndexForValue(value);
  buckets_[index] += 1;
  if (min_ > value) min_ = value;
  if (max_ < value) max_ = value;
  num_++;
  sum_ += value;
  sum_squares_ += (value * value);
}

void HistogramImpl::Merge(const HistogramImpl& other) {
  if (other.min_ < min_) min_ = other.min_;
  if (other.max_ > max_) max_ = other.max_;
  num_ += other.num_;
  sum_ += other.sum_;
  sum_squares_ += other.sum_squares_;
  for (unsigned int b = 0; b < bucketMapper.BucketCount(); b++) {
    buckets_[b] += other.buckets_[b];
  }
}

double HistogramImpl::Median() const {
  return Percentile(50.0);
}

double HistogramImpl::Percentile(double p) const {
  double threshold = num_ * (p / 100.0);
  double sum = 0;
  for (unsigned int b = 0; b < bucketMapper.BucketCount(); b++) {
    sum += buckets_[b];
    if (sum >= threshold) {
      // Scale linearly within this bucket
      double left_point = (b == 0) ? 0 : bucketMapper.BucketLimit(b-1);
      double right_point = bucketMapper.BucketLimit(b);
      double left_sum = sum - buckets_[b];
      double right_sum = sum;
      double pos = 0;
      double right_left_diff = right_sum - left_sum;
      if (right_left_diff != 0) {
       pos = (threshold - left_sum) / (right_sum - left_sum);
      }
      double r = left_point + (right_point - left_point) * pos;
      if (r < min_) r = min_;
      if (r > max_) r = max_;
      return r;
    }
  }
  return max_;
}

double HistogramImpl::Average() const {
  if (num_ == 0.0) return 0;
  return sum_ / num_;
}

double HistogramImpl::StandardDeviation() const {
  if (num_ == 0.0) return 0;
  double variance = (sum_squares_ * num_ - sum_ * sum_) / (num_ * num_);
  return sqrt(variance);
}

std::string HistogramImpl::ToString() const {
  std::string r;
  char buf[200];
  snprintf(buf, sizeof(buf),
           "Count: %.0f  Average: %.4f  StdDev: %.2f\n",
           num_, Average(), StandardDeviation());
  r.append(buf);
  snprintf(buf, sizeof(buf),
           "Min: %.4f  Median: %.4f  Max: %.4f\n",
           (num_ == 0.0 ? 0.0 : min_), Median(), max_);
=======
HistogramStat::HistogramStat()
  : num_buckets_(bucketMapper.BucketCount()) {
  assert(num_buckets_ == sizeof(buckets_) / sizeof(*buckets_));
  Clear();
}

void HistogramStat::Clear() {
  min_.store(bucketMapper.LastValue(), std::memory_order_relaxed);
  max_.store(0, std::memory_order_relaxed);
  num_.store(0, std::memory_order_relaxed);
  sum_.store(0, std::memory_order_relaxed);
  sum_squares_.store(0, std::memory_order_relaxed);
  for (unsigned int b = 0; b < num_buckets_; b++) {
    buckets_[b].store(0, std::memory_order_relaxed);
  }
};

bool HistogramStat::Empty() const { return num() == 0; }

void HistogramStat::Add(uint64_t value) {
  // This function is designed to be lock free, as it's in the critical path
  // of any operation. Each individual value is atomic and the order of updates
  // by concurrent threads is tolerable.
  const size_t index = bucketMapper.IndexForValue(value);
  assert(index < num_buckets_);
  buckets_[index].fetch_add(1, std::memory_order_relaxed);

  uint64_t old_min = min();
  while (value < old_min && !min_.compare_exchange_weak(old_min, value)) {}

  uint64_t old_max = max();
  while (value > old_max && !max_.compare_exchange_weak(old_max, value)) {}

  num_.fetch_add(1, std::memory_order_relaxed);
  sum_.fetch_add(value, std::memory_order_relaxed);
  sum_squares_.fetch_add(value * value, std::memory_order_relaxed);
}

void HistogramStat::Merge(const HistogramStat& other) {
  // This function needs to be performned with the outer lock acquired
  // However, atomic operation on every member is still need, since Add()
  // requires no lock and value update can still happen concurrently
  uint64_t old_min = min();
  uint64_t other_min = other.min();
  while (other_min < old_min &&
         !min_.compare_exchange_weak(old_min, other_min)) {}

  uint64_t old_max = max();
  uint64_t other_max = other.max();
  while (other_max > old_max &&
         !max_.compare_exchange_weak(old_max, other_max)) {}

  num_.fetch_add(other.num(), std::memory_order_relaxed);
  sum_.fetch_add(other.sum(), std::memory_order_relaxed);
  sum_squares_.fetch_add(other.sum_squares(), std::memory_order_relaxed);
  for (unsigned int b = 0; b < num_buckets_; b++) {
    buckets_[b].fetch_add(other.bucket_at(b), std::memory_order_relaxed);
  }
}

double HistogramStat::Median() const {
  return Percentile(50.0);
}

double HistogramStat::Percentile(double p) const {
  double threshold = num() * (p / 100.0);
  uint64_t cumulative_sum = 0;
  for (unsigned int b = 0; b < num_buckets_; b++) {
    uint64_t bucket_value = bucket_at(b);
    cumulative_sum += bucket_value;
    if (cumulative_sum >= threshold) {
      // Scale linearly within this bucket
      uint64_t left_point = (b == 0) ? 0 : bucketMapper.BucketLimit(b-1);
      uint64_t right_point = bucketMapper.BucketLimit(b);
      uint64_t left_sum = cumulative_sum - bucket_value;
      uint64_t right_sum = cumulative_sum;
      double pos = 0;
      uint64_t right_left_diff = right_sum - left_sum;
      if (right_left_diff != 0) {
       pos = (threshold - left_sum) / right_left_diff;
      }
      double r = left_point + (right_point - left_point) * pos;
      uint64_t cur_min = min();
      uint64_t cur_max = max();
      if (r < cur_min) r = static_cast<double>(cur_min);
      if (r > cur_max) r = static_cast<double>(cur_max);
      return r;
    }
  }
  return static_cast<double>(max());
}

double HistogramStat::Average() const {
  uint64_t cur_num = num();
  uint64_t cur_sum = sum();
  if (cur_num == 0) return 0;
  return static_cast<double>(cur_sum) / static_cast<double>(cur_num);
}

double HistogramStat::StandardDeviation() const {
  uint64_t cur_num = num();
  uint64_t cur_sum = sum();
  uint64_t cur_sum_squares = sum_squares();
  if (cur_num == 0) return 0;
  double variance =
      static_cast<double>(cur_sum_squares * cur_num - cur_sum * cur_sum) /
      static_cast<double>(cur_num * cur_num);
  return sqrt(variance);
}
std::string HistogramStat::ToString() const {
  uint64_t cur_num = num();
  std::string r;
  char buf[200];
  snprintf(buf, sizeof(buf),
           "Count: %" PRIu64 " Average: %.4f  StdDev: %.2f\n",
           cur_num, Average(), StandardDeviation());
  r.append(buf);
  snprintf(buf, sizeof(buf),
           "Min: %" PRIu64 "  Median: %.4f  Max: %" PRIu64 "\n",
           (cur_num == 0 ? 0 : min()), Median(), (cur_num == 0 ? 0 : max()));
>>>>>>> forknote/master
  r.append(buf);
  snprintf(buf, sizeof(buf),
           "Percentiles: "
           "P50: %.2f P75: %.2f P99: %.2f P99.9: %.2f P99.99: %.2f\n",
           Percentile(50), Percentile(75), Percentile(99), Percentile(99.9),
           Percentile(99.99));
  r.append(buf);
  r.append("------------------------------------------------------\n");
<<<<<<< HEAD
  const double mult = 100.0 / num_;
  double sum = 0;
  for (unsigned int b = 0; b < bucketMapper.BucketCount(); b++) {
    if (buckets_[b] <= 0.0) continue;
    sum += buckets_[b];
    snprintf(buf, sizeof(buf),
             "[ %7lu, %7lu ) %8lu %7.3f%% %7.3f%% ",
             // left
             (unsigned long)((b == 0) ? 0 : bucketMapper.BucketLimit(b-1)),
             (unsigned long)bucketMapper.BucketLimit(b), // right
             (unsigned long)buckets_[b],                 // count
             (mult * buckets_[b]),        // percentage
             (mult * sum));               // cumulative percentage
    r.append(buf);

    // Add hash marks based on percentage; 20 marks for 100%.
    int marks = static_cast<int>(20*(buckets_[b] / num_) + 0.5);
=======
  const double mult = 100.0 / cur_num;
  uint64_t cumulative_sum = 0;
  for (unsigned int b = 0; b < num_buckets_; b++) {
    uint64_t bucket_value = bucket_at(b);
    if (bucket_value <= 0.0) continue;
    cumulative_sum += bucket_value;
    snprintf(buf, sizeof(buf),
             "[ %7" PRIu64 ", %7" PRIu64 " ) %8" PRIu64 " %7.3f%% %7.3f%% ",
             (b == 0) ? 0 : bucketMapper.BucketLimit(b-1),  // left
              bucketMapper.BucketLimit(b),  // right
              bucket_value,                   // count
             (mult * bucket_value),           // percentage
             (mult * cumulative_sum));       // cumulative percentage
    r.append(buf);

    // Add hash marks based on percentage; 20 marks for 100%.
    size_t marks = static_cast<size_t>(mult * bucket_value / 5 + 0.5);
>>>>>>> forknote/master
    r.append(marks, '#');
    r.push_back('\n');
  }
  return r;
}

<<<<<<< HEAD
void HistogramImpl::Data(HistogramData * const data) const {
=======
void HistogramStat::Data(HistogramData * const data) const {
>>>>>>> forknote/master
  assert(data);
  data->median = Median();
  data->percentile95 = Percentile(95);
  data->percentile99 = Percentile(99);
  data->average = Average();
  data->standard_deviation = StandardDeviation();
}

<<<<<<< HEAD
=======
void HistogramImpl::Clear() {
  std::lock_guard<std::mutex> lock(mutex_);
  stats_.Clear();
}

bool HistogramImpl::Empty() const {
  return stats_.Empty();
}

void HistogramImpl::Add(uint64_t value) {
  stats_.Add(value);
}

void HistogramImpl::Merge(const Histogram& other) {
  if (strcmp(Name(), other.Name()) == 0) {
    Merge(dynamic_cast<const HistogramImpl&>(other));
  }
}

void HistogramImpl::Merge(const HistogramImpl& other) {
  std::lock_guard<std::mutex> lock(mutex_);
  stats_.Merge(other.stats_);
}

double HistogramImpl::Median() const {
  return stats_.Median();
}

double HistogramImpl::Percentile(double p) const {
  return stats_.Percentile(p);
}

double HistogramImpl::Average() const {
  return stats_.Average();
}

double HistogramImpl::StandardDeviation() const {
 return stats_.StandardDeviation();
}

std::string HistogramImpl::ToString() const {
  return stats_.ToString();
}

void HistogramImpl::Data(HistogramData * const data) const {
  stats_.Data(data);
}

>>>>>>> forknote/master
} // namespace levedb
