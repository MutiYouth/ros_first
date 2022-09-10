package com.weng.ros_first.code_glance.render

fun clamp(v: Int, min: Int, max: Int): Int {
    if (v < min) return min
    if (v > max) return max
    return v
}