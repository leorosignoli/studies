package edu.poc.demo.controllers;

import edu.poc.demo.annotations.RequiredHeadersValidation;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomHeaderValidationDemo {

  public static final String CUSTOM_HEADER = "custom-header";

  @PostMapping("/custom-header-validation")
  public String customHeaderValidation(
      @RequestHeader @RequiredHeadersValidation(headers = {CUSTOM_HEADER})
          final Map<String, String> headers) {

    return headers.get(CUSTOM_HEADER);
  }
}
