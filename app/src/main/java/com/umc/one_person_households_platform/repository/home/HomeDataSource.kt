package com.umc.one_person_households_platform.repository.home

import com.umc.one_person_households_platform.model.GroupBuying
import retrofit2.Response

interface HomeDataSource {

    suspend fun getGroupBuyingCategories(): Response<GroupBuying>
}