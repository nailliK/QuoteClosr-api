package io.quoteclosr.api.exception;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(UUID uuid) {
		super("Could not find resource " + uuid);
	}
}
