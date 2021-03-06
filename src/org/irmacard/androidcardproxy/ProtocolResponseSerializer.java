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
import sparta.checkers.quals.*;
import sparta.checkers.quals.FlowPermission;
import static sparta.checkers.quals.FlowPermissionString.*;
*/

/**
 * Helper class to serialize ProtocolResponse to JSON.
 *
 */
public class ProtocolResponseSerializer implements JsonSerializer<ProtocolResponse> {
	@Override
	public /*@Source(ANY) @Sink(INTERNET)*/ JsonElement serialize( /*@Source(NFC)*/ ProtocolResponse src, Type typeOfSrc,
			JsonSerializationContext context) {
		/*@Source(NFC) @Sink(INTERNET)*/ JsonObject obj = new JsonObject();
		obj.addProperty("key", src.getKey());
		obj.addProperty("apdu", Hex.bytesToHexString(src.getAPDU().getBytes()));
		return obj;
	}
}
