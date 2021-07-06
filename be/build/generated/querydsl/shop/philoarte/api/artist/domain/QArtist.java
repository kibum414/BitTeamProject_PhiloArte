package shop.philoarte.api.artist.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArtist is a Querydsl query type for Artist
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArtist extends EntityPathBase<Artist> {

    private static final long serialVersionUID = 1185907342L;

    public static final QArtist artist = new QArtist("artist");

    public final shop.philoarte.api.common.domain.QBaseEntity _super = new shop.philoarte.api.common.domain.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final NumberPath<Long> artistId = createNumber("artistId", Long.class);

    public final StringPath department = createString("department");

    public final StringPath email = createString("email");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final ListPath<shop.philoarte.api.artist.domain.role.Role, EnumPath<shop.philoarte.api.artist.domain.role.Role>> roles = this.<shop.philoarte.api.artist.domain.role.Role, EnumPath<shop.philoarte.api.artist.domain.role.Role>>createList("roles", shop.philoarte.api.artist.domain.role.Role.class, EnumPath.class, PathInits.DIRECT2);

    public final StringPath school = createString("school");

    public final StringPath username = createString("username");

    public QArtist(String variable) {
        super(Artist.class, forVariable(variable));
    }

    public QArtist(Path<? extends Artist> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArtist(PathMetadata metadata) {
        super(Artist.class, metadata);
    }

}

