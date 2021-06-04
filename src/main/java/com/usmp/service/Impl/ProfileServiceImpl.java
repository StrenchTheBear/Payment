package com.usmp.service.Impl;

import com.usmp.entity.Profile;
import com.usmp.repository.ProfileRepository;
import com.usmp.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

}
