package cn.nukkit.network.protocol;

import cn.nukkit.entity.Attribute;
import cn.nukkit.entity.data.EntityMetadata;
import cn.nukkit.utils.Binary;
import cn.nukkit.utils.Link;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class AddEntityPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.ADD_ENTITY_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public long entityUniqueId;
    public long entityRuntimeId;
    public int type;
    public float x;
    public float y;
    public float z;
    public float speedX = 0f;
    public float speedY = 0f;
    public float speedZ = 0f;
    public float yaw;
    public float pitch;
    public EntityMetadata metadata = new EntityMetadata();
    public Attribute[] attributes = new Attribute[0];
    public final Link[] links = new Link[0];

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putEntityUniqueId(this.entityUniqueId);
        this.putEntityRuntimeId(this.entityRuntimeId);
        this.putUnsignedVarInt(this.type);
        this.putVector3f(this.x, this.y, this.z);
        this.putVector3f(this.speedX, this.speedY, this.speedZ);
        this.putLFloat(this.pitch);
        this.putLFloat(this.yaw);
        this.putAttributeList(this.attributes);
        this.put(Binary.writeMetadata(this.metadata));
        this.putUnsignedVarInt(this.links.length);
        for (Link link : this.links) {
            this.putVarLong(link.from);
            this.putVarLong(link.to);
            this.putByte((byte) link.action);
            this.putByte((byte) link.unknownByte);
        }
    }
}
