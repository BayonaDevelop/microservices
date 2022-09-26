package com.bayonasoftware.batteryplus.microservices.utils.model.dtos.generic

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType
import java.io.Serial
import java.io.Serializable

class DropDownDTO  : Serializable {

  @Serial
  private val serialVersionUID = 1L

  var id: JvmType.Object? = null

  var label: String? = null

  var extraData: String? = null

  constructor(id: JvmType.Object, label: String) {
    this.id = id
    this.label = label
  }

  constructor(id: JvmType.Object, label: String, extraData: String) {
    this.id = id
    this.label = label
    this.extraData = extraData
  }

}