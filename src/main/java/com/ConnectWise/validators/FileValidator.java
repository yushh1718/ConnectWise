package com.ConnectWise.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile>  {

    private static final long MAX_FILE_SIZE = 1024 * 1024 * 2; // 2MB

    // type

    // height

    // width


    @Override
    public boolean isValid(MultipartFile file , ConstraintValidatorContext context) {

        if(file == null || file.isEmpty()){
            /*context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("File cannot be empty")
                    .addConstraintViolation();*/
            return true;
        }

        // File Size
        if(file.getSize() > MAX_FILE_SIZE){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("File size should be less than 2MB")
                        .addConstraintViolation();
            return true;
        }

        // Resolution
        /*try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());

            if(bufferedImage.getHeight() < jo bhi height hai) return false;

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return true;
    }
}
