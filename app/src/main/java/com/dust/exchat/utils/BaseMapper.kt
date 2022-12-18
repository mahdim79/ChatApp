package com.dust.exchat.utils

interface BaseMapper<Entity,Model> {
    fun mapToEntity(model: Model):Entity
    fun mapFromEntity(entity: Entity):Model
}