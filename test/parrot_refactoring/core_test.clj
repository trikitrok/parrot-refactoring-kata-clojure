(ns parrot-refactoring.core-test
  (:require
    [midje.sweet :refer :all]
    [parrot-refactoring.core :as parrot]))

(facts
  "about Parrots"

  (fact
    "it gets the speed of a european parrot"
    (parrot/speed (parrot/european)) => 12.0)

  (fact
    "it gets the speed of an african parrot with one coconut"
    (parrot/speed (parrot/african 1)) => 3.0)

  (fact
    "it gets the speed of an african parrot with two coconuts"
    (parrot/speed (parrot/african 2)) => 0.0)

  (fact
    "it gets the speed of an african parrot with no coconuts"
    (parrot/speed (parrot/african 0)) => 12.0)

  (fact
    "it gets the speed of a nailed norwegian blue parrot"
    (parrot/speed (parrot/nailed-norwegian-blue-parrot)) => 0.0)

  (fact
    "it gets the speed of a not nailed norwegian blue parrot"
    (parrot/speed (parrot/norwegian-blue-parrot 1.5)) => 18.0)

  (fact
    "it gets the speed of a not nailed norwegian blue parrot with high voltage"
    (parrot/speed (parrot/norwegian-blue-parrot 4.0)) => 24.0))
