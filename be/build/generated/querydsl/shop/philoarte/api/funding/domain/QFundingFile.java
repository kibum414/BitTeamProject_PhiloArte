package shop.philoarte.api.funding.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFundingFile is a Querydsl query type for FundingFile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFundingFile extends EntityPathBase<FundingFile> {

    private static final long serialVersionUID = -1470739324L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFundingFile fundingFile = new QFundingFile("fundingFile");

    public final StringPath fname = createString("fname");

    public final QFunding funding;

    public final NumberPath<Long> fundingFileId = createNumber("fundingFileId", Long.class);

    public final StringPath uuid = createString("uuid");

    public QFundingFile(String variable) {
        this(FundingFile.class, forVariable(variable), INITS);
    }

    public QFundingFile(Path<? extends FundingFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFundingFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFundingFile(PathMetadata metadata, PathInits inits) {
        this(FundingFile.class, metadata, inits);
    }

    public QFundingFile(Class<? extends FundingFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.funding = inits.isInitialized("funding") ? new QFunding(forProperty("funding"), inits.get("funding")) : null;
    }

}

