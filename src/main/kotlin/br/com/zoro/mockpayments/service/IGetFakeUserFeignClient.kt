package br.com.zoro.mockpayments.service

import br.com.zoro.mockpayments.dto.FakeUserResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@FeignClient(value = "fakeUser", url = "https://random-data-api.com/api/users/random_user")
interface IGetFakeUserFeignClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/"])
    fun getFakeClient(): FakeUserResponse
}