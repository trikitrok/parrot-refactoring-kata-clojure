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

(defn speed [parrot]
  (case (:type parrot)
    :european-parrot (speed parrot)
    :african-parrot (speed parrot)
    :norwegian-blue-parrot (if (:nailed parrot)
                             0.0
                             (compute-base-speed-for-voltage (:voltage parrot)))
    (throw "Should be unreachable!")))

(defn make [type num-coconuts voltage nailed]
  (case type
    :european-parrot (->EuropeanParrot type)
    :african-parrot (->AfricanParrot type num-coconuts)
    {:type type
           :num-coconuts num-coconuts
           :voltage voltage
           :nailed nailed}))