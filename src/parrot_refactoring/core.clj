(ns parrot-refactoring.core)

(def ^:private base-speed 12.0)

(def ^:private minimum-speed 0.0)

(defprotocol Parrot
  (speed [this]))

(defrecord EuropeanParrot []
  Parrot
  (speed [_]
    base-speed))

(defrecord AfricanParrot [num-coconuts]
  Parrot
  (speed [_]
    (let [load-factor 9.0]
      (max minimum-speed (- base-speed (* load-factor num-coconuts))))))

(defrecord NorwegiaBlueParrot [voltage]
  Parrot
  (speed [_]
    (let [maximum-speed 24.0]
      (min maximum-speed (* voltage base-speed)))))

(defrecord NailedNorwegiaBlueParrot []
  Parrot
  (speed [_] minimum-speed))

(defn european []
  (->EuropeanParrot))

(defn african [num-coconuts]
  (->AfricanParrot num-coconuts))

(defn norwegian-blue-parrot [voltage]
  (->NorwegiaBlueParrot voltage))

(defn nailed-norwegian-blue-parrot []
  (->NailedNorwegiaBlueParrot))