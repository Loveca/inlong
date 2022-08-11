package org.apache.inlong.sort.protocol.node.load;

import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.inlong.sort.protocol.FieldInfo;
import org.apache.inlong.sort.protocol.enums.FilterStrategy;
import org.apache.inlong.sort.protocol.node.LoadNode;
import org.apache.inlong.sort.protocol.transformation.FieldRelation;
import org.apache.inlong.sort.protocol.transformation.FilterFunction;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@JsonTypeName("dorisLoad")
@Data
@NoArgsConstructor
public class DorisLoadNode extends LoadNode implements Serializable {
    /**
     * jdbc:mysql://host:port/database
     */
    @JsonProperty("url")
    private String url;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("tableName")
    private String tableName;
    @JsonProperty("primaryKey")
    private String primaryKey;

    @JsonCreator
    public DorisLoadNode(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("fields") List<FieldInfo> fields,
            @JsonProperty("fieldRelations") List<FieldRelation> fieldRelations,
            @JsonProperty("filters") List<FilterFunction> filters,
            @JsonProperty("filterStrategy") FilterStrategy filterStrategy,
            @JsonProperty("sinkParallelism") Integer sinkParallelism,
            @JsonProperty("properties") Map<String, String> properties,
            @JsonProperty("url") String url,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("tableName") String tableName,
            @JsonProperty("primaryKey") String primaryKey) {
        super(id, name, fields, fieldRelations, filters, filterStrategy, sinkParallelism, properties);
        this.url = Preconditions.checkNotNull(url, "url is null");
        this.username = Preconditions.checkNotNull(username, "username is null");
        this.password = Preconditions.checkNotNull(password, "password is null");
        this.tableName = Preconditions.checkNotNull(tableName, "tableName is null");
        this.primaryKey = primaryKey;
    }

    @Override
    public Map<String, String> tableOptions() {
        Map<String, String> options = super.tableOptions();
        options.put("connector", "jdbc-inlong");
        options.put("url", url);
        options.put("username", username);
        options.put("password", password);
        options.put("table-name", tableName);
        return options;
    }

    @Override
    public String genTableName() {
        return String.format("table_%s", super.getId());
    }

    @Override
    public String getPrimaryKey() {
        return primaryKey;
    }

}
