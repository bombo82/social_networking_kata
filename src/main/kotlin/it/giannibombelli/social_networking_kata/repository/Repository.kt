package it.giannibombelli.social_networking_kata.repository

interface Repository<T> {

    fun getOrCreate(userName: String): T

    fun get(userName: String): T?

}