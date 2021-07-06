package shop.philoarte.api.funding.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFunding is a Querydsl query type for Funding
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFunding extends EntityPathBase<Funding> {

    private static final long serialVersionUID = -1096116504L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFunding funding = new QFunding("funding");

    public final shop.philoarte.api.common.domain.QBaseEntity _super = new shop.philoarte.api.common.domain.QBaseEntity(this);

    public final shop.philoarte.api.artist.domain.QArtist artist;

    public final StringPath content = createString("content");

    public final ListPath<FundingFile, QFundingFile> fundingFiles = this.<FundingFile, QFundingFile>createList("fundingFiles", FundingFile.class, QFundingFile.class, PathInits.DIRECT2);

    public final NumberPath<Long> fundingId = createNumber("fundingId", Long.class);

    public final NumberPath<Long> goalPrice = createNumber("goalPrice", Long.class);

    public final StringPath hashtag = createString("hashtag");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath title = createString("title");

    public final NumberPath<Long> viewCnt = createNumber("viewCnt", Long.class);

    public QFunding(String variable) {
        this(Funding.class, forVariable(variable), INITS);
    }

    public QFunding(Path<? extends Funding> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFunding(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFunding(PathMetadata metadata, PathInits inits) {
        this(Funding.class, metadata, inits);
    }

    public QFunding(Class<? extends Funding> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artist = inits.isInitialized("artist") ? new shop.philoarte.api.artist.domain.QArtist(forProperty("artist")) : null;
    }

}

