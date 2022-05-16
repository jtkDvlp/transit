[![Clojars Project](https://img.shields.io/clojars/v/net.clojars.jtkdvlp/transit.svg)](https://clojars.org/net.clojars.jtkdvlp/transit)
[![cljdoc badge](https://cljdoc.org/badge/net.clojars.jtkdvlp/transit)](https://cljdoc.org/d/net.clojars.jtkdvlp/transit/CURRENT)
[![Clojure CI](https://github.com/jtkDvlp/transit/actions/workflows/clojure.yml/badge.svg)](https://github.com/jtkDvlp/transit/actions/workflows/clojure.yml)

# jtk-dvlp.transit

Mini clj and cljs lib for common transit usage.

## Features

- Provides `clj->transit` and `transit->clj` helpers
- Supports clj-time instances

## Getting started

### Get it / add dependency

Add the following dependency to your `project.clj`:<br>
[![Clojars Project](https://img.shields.io/clojars/v/net.clojars.jtkdvlp/transit.svg)](https://clojars.org/net.clojars.jtkdvlp/transit)

### Usage

See in repo [your-project.cljs](https://github.com/jtkdvlp/transit/blob/master/dev/jtk_dvlp/your_project.cljs)

```clojure
(ns jtk-dvlp.your-project
  (:require
   ...
   [jtk-dvlp.transit :refer [clj->transit transit->clj]))

(let [x {:my :cool, :data :yeah}]
  (= x (clj->transit (transit-clj x))))
```

## Appendix

I´d be thankful to receive patches, comments and constructive criticism.

Hope the package is useful :-)
