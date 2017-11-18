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

#pragma once
#include "rocksdb/statistics.h"

#include <cassert>
#include <string>
#include <vector>
#include <map>
<<<<<<< HEAD

#include <string.h>
=======
#include <mutex>
>>>>>>> forknote/master

namespace rocksdb {

class HistogramBucketMapper {
 public:

  HistogramBucketMapper();

  // converts a value to the bucket index.
<<<<<<< HEAD
  size_t IndexForValue(const uint64_t value) const;
=======
  size_t IndexForValue(uint64_t value) const;
>>>>>>> forknote/master
  // number of buckets required.

  size_t BucketCount() const {
    return bucketValues_.size();
  }

  uint64_t LastValue() const {
    return maxBucketValue_;
  }

  uint64_t FirstValue() const {
    return minBucketValue_;
  }

  uint64_t BucketLimit(const size_t bucketNumber) const {
    assert(bucketNumber < BucketCount());
    return bucketValues_[bucketNumber];
  }

 private:
  const std::vector<uint64_t> bucketValues_;
  const uint64_t maxBucketValue_;
  const uint64_t minBucketValue_;
  std::map<uint64_t, uint64_t> valueIndexMap_;
};

<<<<<<< HEAD
class HistogramImpl {
 public:
  HistogramImpl() { memset(buckets_, 0, sizeof(buckets_)); }
  virtual void Clear();
  virtual bool Empty();
  virtual void Add(uint64_t value);
  void Merge(const HistogramImpl& other);

  virtual std::string ToString() const;

  virtual double Median() const;
  virtual double Percentile(double p) const;
  virtual double Average() const;
  virtual double StandardDeviation() const;
  virtual void Data(HistogramData * const data) const;
=======
struct HistogramStat {
  HistogramStat();
  ~HistogramStat() {}

  HistogramStat(const HistogramStat&) = delete;
  HistogramStat& operator=(const HistogramStat&) = delete;

  void Clear();
  bool Empty() const;
  void Add(uint64_t value);
  void Merge(const HistogramStat& other);

  inline uint64_t min() const { return min_.load(std::memory_order_relaxed); }
  inline uint64_t max() const { return max_.load(std::memory_order_relaxed); }
  inline uint64_t num() const { return num_.load(std::memory_order_relaxed); }
  inline uint64_t sum() const { return sum_.load(std::memory_order_relaxed); }
  inline uint64_t sum_squares() const {
    return sum_squares_.load(std::memory_order_relaxed);
  }
  inline uint64_t bucket_at(size_t b) const {
    return buckets_[b].load(std::memory_order_relaxed);
  }

  double Median() const;
  double Percentile(double p) const;
  double Average() const;
  double StandardDeviation() const;
  void Data(HistogramData* const data) const;
  std::string ToString() const;

  // To be able to use HistogramStat as thread local variable, it
  // cannot have dynamic allocated member. That's why we're
  // using manually values from BucketMapper
  std::atomic_uint_fast64_t min_;
  std::atomic_uint_fast64_t max_;
  std::atomic_uint_fast64_t num_;
  std::atomic_uint_fast64_t sum_;
  std::atomic_uint_fast64_t sum_squares_;
  std::atomic_uint_fast64_t buckets_[138]; // 138==BucketMapper::BucketCount()
  const uint64_t num_buckets_;
};

class Histogram {
public:
  Histogram() {}
  virtual ~Histogram() {};

  virtual void Clear() = 0;
  virtual bool Empty() const = 0;
  virtual void Add(uint64_t value) = 0;
  virtual void Merge(const Histogram&) = 0;

  virtual std::string ToString() const = 0;
  virtual const char* Name() const = 0;
  virtual uint64_t min() const = 0;
  virtual uint64_t max() const = 0;
  virtual uint64_t num() const = 0;
  virtual double Median() const = 0;
  virtual double Percentile(double p) const = 0;
  virtual double Average() const = 0;
  virtual double StandardDeviation() const = 0;
  virtual void Data(HistogramData* const data) const = 0;
};

class HistogramImpl : public Histogram {
 public:
  HistogramImpl() { Clear(); }

  HistogramImpl(const HistogramImpl&) = delete;
  HistogramImpl& operator=(const HistogramImpl&) = delete;

  virtual void Clear() override;
  virtual bool Empty() const override;
  virtual void Add(uint64_t value) override;
  virtual void Merge(const Histogram& other) override;
  void Merge(const HistogramImpl& other);

  virtual std::string ToString() const override;
  virtual const char* Name() const override { return "HistogramImpl"; }
  virtual uint64_t min() const override { return stats_.min(); }
  virtual uint64_t max() const override { return stats_.max(); }
  virtual uint64_t num() const override { return stats_.num(); }
  virtual double Median() const override;
  virtual double Percentile(double p) const override;
  virtual double Average() const override;
  virtual double StandardDeviation() const override;
  virtual void Data(HistogramData* const data) const override;
>>>>>>> forknote/master

  virtual ~HistogramImpl() {}

 private:
<<<<<<< HEAD
  // To be able to use HistogramImpl as thread local variable, its constructor
  // has to be static. That's why we're using manually values from BucketMapper
  double min_ = 1000000000;  // this is BucketMapper:LastValue()
  double max_ = 0;
  double num_ = 0;
  double sum_ = 0;
  double sum_squares_ = 0;
  uint64_t buckets_[138];  // this is BucketMapper::BucketCount()
};

}  // namespace rocksdb
=======
  HistogramStat stats_;
  std::mutex mutex_;
};

}  // namespace rocksdb
>>>>>>> forknote/master
