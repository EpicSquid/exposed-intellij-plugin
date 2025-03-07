package dev.epicsquid.exposed.gradle.time

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.javatime.time
import org.joda.time.LocalTime
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.reflect.KClass
import kotlin.reflect.KFunction

@Suppress("UNCHECKED_CAST")
object JavaDateTimeProvider : DateTimeProvider {
	override val dateClass: KClass<LocalDate> = LocalDate::class
	override val dateTimeClass: KClass<LocalDateTime> = LocalDateTime::class
	override val timeClass: KClass<LocalTime> = LocalTime::class

	override fun <S> dateTableFun(): KFunction<Column<S>> {
		return Table::date as KFunction<Column<S>>
	}

	override fun <S> dateTimeTableFun(): KFunction<Column<S>> {
		return Table::datetime as KFunction<Column<S>>
	}

	override fun <S> timeTableFun(): KFunction<Column<S>> {
		return Table::time as KFunction<Column<S>>
	}

}