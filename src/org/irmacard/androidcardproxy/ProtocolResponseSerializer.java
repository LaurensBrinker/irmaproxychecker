package org.irmacard.androidcardproxy;

import java.lang.reflect.Type;

import net.sf.scuba.smartcards.ProtocolResponse;
import net.sf.scuba.util.Hex;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.annotation.Target; 
import java.lang.annotation.ElementType;

/*>>>import sparta.checkers.quals.Sink;
import sparta.checkers.quals.Source;
*/

/**
 * Helper class to serialize ProtocolResponse to JSON.
 *
 */
public class ProtocolResponseSerializer implements JsonSerializer<ProtocolResponse> {
	@Override
	public JsonElement serialize(ProtocolResponse src, Type typeOfSrc,
			JsonSerializationContext context) {
		/*@Source("USER_INPUT")*/JsonObject obj = new JsonObject();
		obj.addProperty("key", src.getKey());
		obj.addProperty("apdu", Hex.bytesToHexString(src.getAPDU().getBytes()));
		return obj;
	}
}
