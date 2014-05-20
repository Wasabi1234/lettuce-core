package com.lambdaworks.redis.output;

import java.nio.ByteBuffer;

import com.lambdaworks.redis.ValueScanCursor;
import com.lambdaworks.redis.codec.RedisCodec;

/**
 * {@link com.lambdaworks.redis.ValueScanCursor} for scan cursor output.
 * 
 * @author <a href="mailto:mark.paluch@1und1.de">Mark Paluch</a>
 */
public class ValueScanOutput<K, V> extends ScanOutput<K, V, ValueScanCursor<V>> {

    public ValueScanOutput(RedisCodec<K, V> codec) {
        super(codec, new ValueScanCursor<V>());
    }

    @Override
    protected void setOutput(ByteBuffer bytes) {
        output.getValues().add(bytes == null ? null : codec.decodeValue(bytes));
    }

}
