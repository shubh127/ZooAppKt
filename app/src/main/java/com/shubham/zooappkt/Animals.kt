package com.shubham.zooappkt

class Animals {
    var name: String? = null
    var description: String? = null
    var imageId: Int? = null
    var isKiller: Boolean = false

    constructor(name: String, description: String, imageId: Int, isKiller: Boolean) {
        this.name = name
        this.description = description
        this.imageId = imageId
        this.isKiller = isKiller
    }
}