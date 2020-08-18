package com.mvvm.pathfinder

class InfoObject {
    var name: String
    var text: String
    var link: String
    var rank: Int
    var stat: Int
    var bonus: Int

    constructor(nameArg: String, textArg: String, linkArg: String, rankArg: Int, statArg: Int, bonusArg: Int) {
        name = nameArg
        text = textArg
        link = linkArg
        rank = rankArg
        stat = statArg
        bonus = bonusArg
    }

    constructor() {
        name = "???"
        text = "???"
        link = "???"
        rank = 0
        stat = 0
        bonus = 0
    }
}