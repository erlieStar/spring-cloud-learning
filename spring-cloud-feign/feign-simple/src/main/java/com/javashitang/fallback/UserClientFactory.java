package com.javashitang.fallback;

import com.javashitang.msdao.UserClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserClientFactory implements FallbackFactory<UserClient> {

		public UserClient create(Throwable throwable) {
				return new UserClient() {
						public String getProduct(long id) {
								return "调用用户系统异常";
						}
				};
		}
}
