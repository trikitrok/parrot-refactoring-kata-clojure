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

(defrecord NorwegiaBlueParrot [voltage nailed]
  Parrot
  (speed [_]
    (min 24.0 (* voltage base-speed))))

(defrecord NailedParrot []
  Parrot
  (speed [_] minimum-speed))

(defn make [type num-coconuts voltage nailed]
  (if nailed
    (->NailedParrot)
    (case type
      :european-parrot (->EuropeanParrot)
      :african-parrot (->AfricanParrot num-coconuts)
      :norwegian-blue-parrot (->NorwegiaBlueParrot voltage nailed)
      (throw "Should be unreachable!"))))