package com.weng.ros_first.code_glance_pro.config.enums

import com.weng.ros_first.code_glance_pro.util.message

enum class MouseJumpEnum(private val messageCode:String){
	NONE("settings.jump.none"),
	MOUSE_DOWN("settings.jump.down"),
	MOUSE_UP("settings.jump.up"),
	;

	fun getMessage():String{
		return message(messageCode)
	}

	companion object{
		@JvmStatic
		fun findMouseJumpEnum(message:String?):MouseJumpEnum{
			return MouseJumpEnum.values().find { it.getMessage() == message }!!
		}
	}
}