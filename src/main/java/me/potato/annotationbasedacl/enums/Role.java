package me.potato.annotationbasedacl.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Getter;
import me.potato.annotationbasedacl.config.EnumCode;

/**
 * @author dongju.paek
 */
@Getter
public enum Role implements EnumCode<Role> {
	ADMIN(100),
	USER(200);

	private static final ConcurrentHashMap<Integer, Role> codeMap = new ConcurrentHashMap<>();

	static {
		Arrays.stream(values()).forEach(value -> codeMap.put(value.getCode(), value));
	}

	private final Integer code;

	Role(Integer code) {
		this.code = code;
	}

	@Override
	public Optional<Role> search(String code) {
		return Optional.ofNullable(codeMap.get(Integer.parseInt(code)));
	}
}
