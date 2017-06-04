package cn.nukkit.network.protocol;

/**
 * author: MagicDroidX & iNevet
 * Nukkit Project
 */
public interface ProtocolInfo {

    /**
     * Actual Minecraft: PE protocol version
     */
    byte CURRENT_PROTOCOL = 113;
    String MINECRAFT_VERSION = "v1.1.0";
    String MINECRAFT_VERSION_NETWORK = "1.1.0";

    byte LOGIN_PACKET = 0x01;
    byte PLAY_STATUS_PACKET = 0x02;
    byte SERVER_TO_CLIENT_HANDSHAKE_PACKET = 0x03;
    byte CLIENT_TO_SERVER_HANDSHAKE_PACKET = 0x04;
    byte DISCONNECT_PACKET = 0x05;
    byte RESOURCE_PACKS_INFO_PACKET = 0x06;
    byte RESOURCE_PACK_STACK_PACKET = 0x07;
    byte RESOURCE_PACK_CLIENT_RESPONSE_PACKET = 0x08;
    byte TEXT_PACKET = 0x09;
    byte SET_TIME_PACKET = 0x0a;
    byte START_GAME_PACKET = 0x0b;
    byte ADD_PLAYER_PACKET = 0x0c;
    byte ADD_ENTITY_PACKET = 0x0d;
    byte REMOVE_ENTITY_PACKET = 0x0e;
    byte ADD_ITEM_ENTITY_PACKET = 0x0f;
    byte ADD_HANGING_ENTITY_PACKET = 0x10;
    byte TAKE_ITEM_ENTITY_PACKET = 0x11;
    byte MOVE_ENTITY_PACKET = 0x12;
    byte MOVE_PLAYER_PACKET = 0x13;
    byte RIDER_JUMP_PACKET = 0x14;
    byte REMOVE_BLOCK_PACKET = 0x15;
    byte UPDATE_BLOCK_PACKET = 0x16;
    byte ADD_PAINTING_PACKET = 0x17;
    byte EXPLODE_PACKET = 0x18;
    byte LEVEL_SOUND_EVENT_PACKET = 0x19;
    byte LEVEL_EVENT_PACKET = 0x1a;
    byte BLOCK_EVENT_PACKET = 0x1b;
    byte ENTITY_EVENT_PACKET = 0x1c;
    byte MOB_EFFECT_PACKET = 0x1d;
    byte UPDATE_ATTRIBUTES_PACKET = 0x1e;
    byte MOB_EQUIPMENT_PACKET = 0x1f;
    byte MOB_ARMOR_EQUIPMENT_PACKET = 0x20;
    byte INTERACT_PACKET = 0x21;
    byte BLOCK_PICK_REQUEST_PACKET = 0x22;
    byte USE_ITEM_PACKET = 0x23;
    byte PLAYER_ACTION_PACKET = 0x24;
    byte ENTITY_FALL_PACKET = 0x25;
    byte HURT_ARMOR_PACKET = 0x26;
    byte SET_ENTITY_DATA_PACKET = 0x27;
    byte SET_ENTITY_MOTION_PACKET = 0x28;
    byte SET_ENTITY_LINK_PACKET = 0x29;
    byte SET_HEALTH_PACKET = 0x2a;
    byte SET_SPAWN_POSITION_PACKET = 0x2b;
    byte ANIMATE_PACKET = 0x2c;
    byte RESPAWN_PACKET = 0x2d;
    byte DROP_ITEM_PACKET = 0x2e;
    byte INVENTORY_ACTION_PACKET = 0x2f;
    byte CONTAINER_OPEN_PACKET = 0x30;
    byte CONTAINER_CLOSE_PACKET = 0x31;
    byte CONTAINER_SET_SLOT_PACKET = 0x32;
    byte CONTAINER_SET_DATA_PACKET = 0x33;
    byte CONTAINER_SET_CONTENT_PACKET = 0x34;
    byte CRAFTING_DATA_PACKET = 0x35;
    byte CRAFTING_EVENT_PACKET = 0x36;
    byte ADVENTURE_SETTINGS_PACKET = 0x37;
    byte BLOCK_ENTITY_DATA_PACKET = 0x38;
    byte PLAYER_INPUT_PACKET = 0x39;
    byte FULL_CHUNK_DATA_PACKET = 0x3a;
    byte SET_COMMANDS_ENABLED_PACKET = 0x3b;
    byte SET_DIFFICULTY_PACKET = 0x3c;
    byte CHANGE_DIMENSION_PACKET = 0x3d;
    byte SET_PLAYER_GAME_TYPE_PACKET = 0x3e;
    byte PLAYER_LIST_PACKET = 0x3f;
    byte SIMPLE_EVENT_PACKET = 0x40;
    byte EVENT_PACKET = 0x41;
    byte SPAWN_EXPERIENCE_ORB_PACKET = 0x42;
    byte CLIENTBOUND_MAP_ITEM_DATA_PACKET = 0x43;
    byte MAP_INFO_REQUEST_PACKET = 0x44;
    byte REQUEST_CHUNK_RADIUS_PACKET = 0x45;
    byte CHUNK_RADIUS_UPDATED_PACKET = 0x46;
    byte ITEM_FRAME_DROP_ITEM_PACKET = 0x47;
    byte REPLACE_ITEM_IN_SLOT_PACKET = 0x48; //ReplaceSelectedItemPacket
    byte GAME_RULES_CHANGED_PACKET = 0x49;
    byte CAMERA_PACKET = 0x4a;
    byte ADD_ITEM_PACKET = 0x4b;
    byte BOSS_EVENT_PACKET = 0x4c;
    byte SHOW_CREDITS_PACKET = 0x4d;
    byte AVAILABLE_COMMANDS_PACKET = 0x4e;
    byte COMMAND_STEP_PACKET = 0x4f;
    byte COMMAND_BLOCK_UPDATE_PACKET = 0x50;
    byte UPDATE_TRADE_PACKET = 0x51;
    byte UPDATE_EQUIP_PACKET = 0x52;
    byte RESOURCE_PACK_DATA_INFO_PACKET = 0x53;
    byte RESOURCE_PACK_CHUNK_DATA_PACKET = 0x54;
    byte RESOURCE_PACK_CHUNK_REQUEST_PACKET = 0x55;
    byte TRANSFER_PACKET = 0x56;
    byte PLAY_SOUND_PACKET = 0x57;
    byte STOP_SOUND_PACKET = 0x58;
    byte SET_TITLE_PACKET = 0x59;
    byte ADD_BEHAVIOR_TREE_PACKET = 0x5a;
    byte STRUCTURE_BLOCK_UPDATE_PACKET = 0x5b;
    byte BATCH_PACKET = (byte) 0xff;
}