package projet.commun;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import projet.data.Benevole;
import projet.data.Participant;
import projet.data.Competition;
import projet.data.AdminAppli;
import projet.data.Equipe;


@Mapper
public interface IMapper {  
	
	Participant update( @MappingTarget Participant target, Participant source  );
	
	Benevole update( @MappingTarget Benevole target, Benevole source );

	@Mapping( target="categorie", expression="java( source.getCategorie() )" )
	AdminAppli update( @MappingTarget AdminAppli target, AdminAppli source );

	@Mapping( target="categorie", expression="java( source.getCategorie() )" )
	Competition update( @MappingTarget Competition target, Competition source );

	Equipe update( @MappingTarget Equipe target, Equipe source );
	
}
