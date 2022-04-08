// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: messagepush.proto

package com.whmf.mars.chat.proto;

public final class Messagepush {
  private Messagepush() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MessagePushOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.whmf.mars.chat.proto.MessagePush)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string topic = 1;</code>
     * @return Whether the topic field is set.
     */
    boolean hasTopic();
    /**
     * <code>required string topic = 1;</code>
     * @return The topic.
     */
    java.lang.String getTopic();
    /**
     * <code>required string topic = 1;</code>
     * @return The bytes for topic.
     */
    com.google.protobuf.ByteString
        getTopicBytes();

    /**
     * <code>required string content = 2;</code>
     * @return Whether the content field is set.
     */
    boolean hasContent();
    /**
     * <code>required string content = 2;</code>
     * @return The content.
     */
    java.lang.String getContent();
    /**
     * <code>required string content = 2;</code>
     * @return The bytes for content.
     */
    com.google.protobuf.ByteString
        getContentBytes();

    /**
     * <code>required string from = 3;</code>
     * @return Whether the from field is set.
     */
    boolean hasFrom();
    /**
     * <code>required string from = 3;</code>
     * @return The from.
     */
    java.lang.String getFrom();
    /**
     * <code>required string from = 3;</code>
     * @return The bytes for from.
     */
    com.google.protobuf.ByteString
        getFromBytes();
  }
  /**
   * Protobuf type {@code com.whmf.mars.chat.proto.MessagePush}
   */
  public static final class MessagePush extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.whmf.mars.chat.proto.MessagePush)
      MessagePushOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use MessagePush.newBuilder() to construct.
    private MessagePush(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MessagePush() {
      topic_ = "";
      content_ = "";
      from_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new MessagePush();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private MessagePush(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              topic_ = bs;
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              content_ = bs;
              break;
            }
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000004;
              from_ = bs;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.whmf.mars.chat.proto.Messagepush.internal_static_com_whmf_mars_chat_proto_MessagePush_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.whmf.mars.chat.proto.Messagepush.internal_static_com_whmf_mars_chat_proto_MessagePush_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.whmf.mars.chat.proto.Messagepush.MessagePush.class, com.whmf.mars.chat.proto.Messagepush.MessagePush.Builder.class);
    }

    private int bitField0_;
    public static final int TOPIC_FIELD_NUMBER = 1;
    private volatile java.lang.Object topic_;
    /**
     * <code>required string topic = 1;</code>
     * @return Whether the topic field is set.
     */
    @java.lang.Override
    public boolean hasTopic() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required string topic = 1;</code>
     * @return The topic.
     */
    @java.lang.Override
    public java.lang.String getTopic() {
      java.lang.Object ref = topic_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          topic_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string topic = 1;</code>
     * @return The bytes for topic.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getTopicBytes() {
      java.lang.Object ref = topic_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        topic_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CONTENT_FIELD_NUMBER = 2;
    private volatile java.lang.Object content_;
    /**
     * <code>required string content = 2;</code>
     * @return Whether the content field is set.
     */
    @java.lang.Override
    public boolean hasContent() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required string content = 2;</code>
     * @return The content.
     */
    @java.lang.Override
    public java.lang.String getContent() {
      java.lang.Object ref = content_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          content_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string content = 2;</code>
     * @return The bytes for content.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int FROM_FIELD_NUMBER = 3;
    private volatile java.lang.Object from_;
    /**
     * <code>required string from = 3;</code>
     * @return Whether the from field is set.
     */
    @java.lang.Override
    public boolean hasFrom() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>required string from = 3;</code>
     * @return The from.
     */
    @java.lang.Override
    public java.lang.String getFrom() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          from_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string from = 3;</code>
     * @return The bytes for from.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getFromBytes() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        from_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasTopic()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasContent()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasFrom()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, topic_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, content_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, from_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, topic_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, content_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, from_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.whmf.mars.chat.proto.Messagepush.MessagePush)) {
        return super.equals(obj);
      }
      com.whmf.mars.chat.proto.Messagepush.MessagePush other = (com.whmf.mars.chat.proto.Messagepush.MessagePush) obj;

      if (hasTopic() != other.hasTopic()) return false;
      if (hasTopic()) {
        if (!getTopic()
            .equals(other.getTopic())) return false;
      }
      if (hasContent() != other.hasContent()) return false;
      if (hasContent()) {
        if (!getContent()
            .equals(other.getContent())) return false;
      }
      if (hasFrom() != other.hasFrom()) return false;
      if (hasFrom()) {
        if (!getFrom()
            .equals(other.getFrom())) return false;
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasTopic()) {
        hash = (37 * hash) + TOPIC_FIELD_NUMBER;
        hash = (53 * hash) + getTopic().hashCode();
      }
      if (hasContent()) {
        hash = (37 * hash) + CONTENT_FIELD_NUMBER;
        hash = (53 * hash) + getContent().hashCode();
      }
      if (hasFrom()) {
        hash = (37 * hash) + FROM_FIELD_NUMBER;
        hash = (53 * hash) + getFrom().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.whmf.mars.chat.proto.Messagepush.MessagePush parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.whmf.mars.chat.proto.Messagepush.MessagePush prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.whmf.mars.chat.proto.MessagePush}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.whmf.mars.chat.proto.MessagePush)
        com.whmf.mars.chat.proto.Messagepush.MessagePushOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.whmf.mars.chat.proto.Messagepush.internal_static_com_whmf_mars_chat_proto_MessagePush_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.whmf.mars.chat.proto.Messagepush.internal_static_com_whmf_mars_chat_proto_MessagePush_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.whmf.mars.chat.proto.Messagepush.MessagePush.class, com.whmf.mars.chat.proto.Messagepush.MessagePush.Builder.class);
      }

      // Construct using com.whmf.mars.chat.proto.Messagepush.MessagePush.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        topic_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        content_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        from_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.whmf.mars.chat.proto.Messagepush.internal_static_com_whmf_mars_chat_proto_MessagePush_descriptor;
      }

      @java.lang.Override
      public com.whmf.mars.chat.proto.Messagepush.MessagePush getDefaultInstanceForType() {
        return com.whmf.mars.chat.proto.Messagepush.MessagePush.getDefaultInstance();
      }

      @java.lang.Override
      public com.whmf.mars.chat.proto.Messagepush.MessagePush build() {
        com.whmf.mars.chat.proto.Messagepush.MessagePush result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.whmf.mars.chat.proto.Messagepush.MessagePush buildPartial() {
        com.whmf.mars.chat.proto.Messagepush.MessagePush result = new com.whmf.mars.chat.proto.Messagepush.MessagePush(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          to_bitField0_ |= 0x00000001;
        }
        result.topic_ = topic_;
        if (((from_bitField0_ & 0x00000002) != 0)) {
          to_bitField0_ |= 0x00000002;
        }
        result.content_ = content_;
        if (((from_bitField0_ & 0x00000004) != 0)) {
          to_bitField0_ |= 0x00000004;
        }
        result.from_ = from_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.whmf.mars.chat.proto.Messagepush.MessagePush) {
          return mergeFrom((com.whmf.mars.chat.proto.Messagepush.MessagePush)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.whmf.mars.chat.proto.Messagepush.MessagePush other) {
        if (other == com.whmf.mars.chat.proto.Messagepush.MessagePush.getDefaultInstance()) return this;
        if (other.hasTopic()) {
          bitField0_ |= 0x00000001;
          topic_ = other.topic_;
          onChanged();
        }
        if (other.hasContent()) {
          bitField0_ |= 0x00000002;
          content_ = other.content_;
          onChanged();
        }
        if (other.hasFrom()) {
          bitField0_ |= 0x00000004;
          from_ = other.from_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        if (!hasTopic()) {
          return false;
        }
        if (!hasContent()) {
          return false;
        }
        if (!hasFrom()) {
          return false;
        }
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.whmf.mars.chat.proto.Messagepush.MessagePush parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.whmf.mars.chat.proto.Messagepush.MessagePush) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object topic_ = "";
      /**
       * <code>required string topic = 1;</code>
       * @return Whether the topic field is set.
       */
      public boolean hasTopic() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>required string topic = 1;</code>
       * @return The topic.
       */
      public java.lang.String getTopic() {
        java.lang.Object ref = topic_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            topic_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string topic = 1;</code>
       * @return The bytes for topic.
       */
      public com.google.protobuf.ByteString
          getTopicBytes() {
        java.lang.Object ref = topic_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          topic_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string topic = 1;</code>
       * @param value The topic to set.
       * @return This builder for chaining.
       */
      public Builder setTopic(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        topic_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string topic = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearTopic() {
        bitField0_ = (bitField0_ & ~0x00000001);
        topic_ = getDefaultInstance().getTopic();
        onChanged();
        return this;
      }
      /**
       * <code>required string topic = 1;</code>
       * @param value The bytes for topic to set.
       * @return This builder for chaining.
       */
      public Builder setTopicBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        topic_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object content_ = "";
      /**
       * <code>required string content = 2;</code>
       * @return Whether the content field is set.
       */
      public boolean hasContent() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>required string content = 2;</code>
       * @return The content.
       */
      public java.lang.String getContent() {
        java.lang.Object ref = content_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            content_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string content = 2;</code>
       * @return The bytes for content.
       */
      public com.google.protobuf.ByteString
          getContentBytes() {
        java.lang.Object ref = content_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          content_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string content = 2;</code>
       * @param value The content to set.
       * @return This builder for chaining.
       */
      public Builder setContent(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        content_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string content = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearContent() {
        bitField0_ = (bitField0_ & ~0x00000002);
        content_ = getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      /**
       * <code>required string content = 2;</code>
       * @param value The bytes for content to set.
       * @return This builder for chaining.
       */
      public Builder setContentBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        content_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object from_ = "";
      /**
       * <code>required string from = 3;</code>
       * @return Whether the from field is set.
       */
      public boolean hasFrom() {
        return ((bitField0_ & 0x00000004) != 0);
      }
      /**
       * <code>required string from = 3;</code>
       * @return The from.
       */
      public java.lang.String getFrom() {
        java.lang.Object ref = from_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            from_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string from = 3;</code>
       * @return The bytes for from.
       */
      public com.google.protobuf.ByteString
          getFromBytes() {
        java.lang.Object ref = from_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          from_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string from = 3;</code>
       * @param value The from to set.
       * @return This builder for chaining.
       */
      public Builder setFrom(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        from_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string from = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearFrom() {
        bitField0_ = (bitField0_ & ~0x00000004);
        from_ = getDefaultInstance().getFrom();
        onChanged();
        return this;
      }
      /**
       * <code>required string from = 3;</code>
       * @param value The bytes for from to set.
       * @return This builder for chaining.
       */
      public Builder setFromBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        from_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.whmf.mars.chat.proto.MessagePush)
    }

    // @@protoc_insertion_point(class_scope:com.whmf.mars.chat.proto.MessagePush)
    private static final com.whmf.mars.chat.proto.Messagepush.MessagePush DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.whmf.mars.chat.proto.Messagepush.MessagePush();
    }

    public static com.whmf.mars.chat.proto.Messagepush.MessagePush getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<MessagePush>
        PARSER = new com.google.protobuf.AbstractParser<MessagePush>() {
      @java.lang.Override
      public MessagePush parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new MessagePush(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<MessagePush> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MessagePush> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.whmf.mars.chat.proto.Messagepush.MessagePush getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_whmf_mars_chat_proto_MessagePush_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_whmf_mars_chat_proto_MessagePush_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021messagepush.proto\022\030com.whmf.mars.chat." +
      "proto\";\n\013MessagePush\022\r\n\005topic\030\001 \002(\t\022\017\n\007c" +
      "ontent\030\002 \002(\t\022\014\n\004from\030\003 \002(\t"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_whmf_mars_chat_proto_MessagePush_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_whmf_mars_chat_proto_MessagePush_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_whmf_mars_chat_proto_MessagePush_descriptor,
        new java.lang.String[] { "Topic", "Content", "From", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
