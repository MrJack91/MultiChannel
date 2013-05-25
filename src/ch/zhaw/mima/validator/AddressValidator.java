package ch.zhaw.mima.validator;

import ch.zhaw.mima.addresses.Address;
/**
 * 
 */

/**
 * @author michael
 *
 */
public interface AddressValidator<T extends Address>  {
	

	public void validate(T address) throws AddressValidatorException;
	

}
