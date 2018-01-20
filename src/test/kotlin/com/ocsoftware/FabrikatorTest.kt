package com.ocsoftware

import io.kotlintest.matchers.shouldEqual
import io.kotlintest.specs.StringSpec

class FabrikatorTest : StringSpec({
  "raises an error if the factory is not defined" {
    1 shouldEqual 2
  }

  "build returns the matching factory" {
    // TODO implement and enable
  }.config(enabled=false)

  "build merges passed in options" {
    // TODO implement and enable
  }.config(enabled=false)

  "build raises an exception if invalid keys are passed in via options" {
    // TODO implement and enable
  }.config(enabled=false)

  "buildPair builds 2 factories" {
    // TODO implement and enable
  }.config(enabled=false)

  "buildList builds the factory passed in the number of times" {
    // TODO implement and enable
  }.config(enabled=false)

  "buildList handles the number 0" {
    // TODO implement and enable
  }.config(enabled=false)
})