package ru.brill;

import ru.brill.dto.PersonInfoDto;
import ru.brill.dto.PledgeResultDto;

public interface PledgeService {

    PledgeResultDto getPledgeList(PersonInfoDto person);
}
