(ns parrot-refactoring.core-test
  (:require
    [midje.sweet :refer :all]
    [parrot-refactoring.core :as parrot]))

(facts
  "about Parrots"

  (fact
    "it gets the speed of a european parrot"

    (parrot/speed
      (parrot/make :european-parrot 0 0.0 false)) => 12.0)

  (fact
    "it gets the speed of an african parrot with one coconut"

    (parrot/speed
      (parrot/make :african-parrot 1 0.0 false)) => 3.0)

  (fact
    "it gets the speed of an african parrot with two coconuts"

    (parrot/speed
      (parrot/make :african-parrot 2 0.0 false)) => 0.0)

  (fact
    "it gets the speed of an african parrot with no coconuts"

    (parrot/speed
      (parrot/make :african-parrot 0 0.0 false)) => 12.0)

  (fact
    "it gets the speed of a nailed norwegian blue parrot"

    (parrot/speed
      (parrot/make :norwegian-blue-parrot 0 0.0 true)) => 0.0)

  (fact
    "it gets the speed of a not nailed norwegian blue parrot"

    (parrot/speed
      (parrot/make :norwegian-blue-parrot 0 1.5 false)) => 18.0)

  (fact
    "it gets the speed of a not nailed norwegian blue parrot with high voltage"

    (parrot/speed
      (parrot/make :norwegian-blue-parrot 0 4.0 false)) => 24.0))
