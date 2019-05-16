package com.murtazin.vkapp.moxy

object Repository {
    var firstName: String = "Эмиль"
    var lastName: String = "Муртазин"
    var status: String = "Vallar Morghulis"
    var birthday: String = "14.07.98"
    var sex: String = "Мужской"
    var city: String = "Томск"
    var country: String = "Россия"
    var education: String = "ТПУ Инженерная школа информационных технологий и робототехники (бывш. Институт кибернетики)"


    fun setData(
        firstName: String,
        lastName: String,
        status: String,
        birthday: String,
        sex: String,
        city: String,
        country: String,
        education: String
    ) {
        this.firstName = firstName
        this.lastName = lastName
        this.status = status
        this.birthday = birthday
        this.sex = sex
        this.city = city
        this.country = country
        this.education = education
    }

    fun getData() = listOf<String>(firstName, lastName, status, birthday, sex, city, country, education)
}


