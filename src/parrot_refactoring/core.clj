(ns parrot-refactoring.core)

(def ^:private load-factor 9.0)

(def ^:private base-speed 12.0)

(defn- compute-base-speed-for-voltage [voltage]
  (min 24.0 (* voltage base-speed)))

(defprotocol Parrot
  (speed [this]))

(defrecord EuropeanParrot [type]
  Parrot
  (speed [_]
    base-speed))

(defrecord AfricanParrot [type num-coconuts]
  Parrot
  (speed [_]
    (max 0.0 (- base-speed (* load-factor num-coconuts)))))

(defrecord NorwegiaBlueParrot [type voltage nailed]
  Parrot
  (speed [_]
    (compute-base-speed-for-voltage voltage)))

(defrecord NailedParrot []
  Parrot
  (speed [_] 0.0))

(defn make [type num-coconuts voltage nailed]
  (if nailed
    (->NailedParrot)
    (case type
      :european-parrot (->EuropeanParrot type)
      :african-parrot (->AfricanParrot type num-coconuts)
      :norwegian-blue-parrot (->NorwegiaBlueParrot type voltage nailed)
      (throw "Should be unreachable!"))))