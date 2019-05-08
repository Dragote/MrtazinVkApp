package com.gmail.intellect.logos.vkapp.moxy

object Repository {
    var firstName: String = ""
    var lastName: String = ""
    var status: String = ""
    var birthday: String = ""
    var sex: String = ""
    var city: String = ""
    var country: String = ""
    var education: String = ""

    fun initRepository() {
        firstName = "Эмиль"
        lastName = "Муртазин"
        status = "Vallar Morhulis"
        birthday = "14.07.98"
        sex = "Мужской"
        city = "Томск"
        country = "Россия"
        education = "ТПУ Инженерная школа информационных технологий и робототехники (бывш. Институт кибернетики)"

    }

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


