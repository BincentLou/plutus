package org.mybatis.generator;

import org.mybatis.generator.api.ExtMyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.config.xml.ExtConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorStartUp {

    private static Logger logger = LoggerFactory.getLogger(GeneratorStartUp.class);


    public static void main(String[] args) {
        boolean overwrite = true;
        List<String> warnings = new ArrayList<String>();
        File configFile = new File(GeneratorStartUp.class.getResource("/generatorConfig.xml").getFile());
        ConfigurationParser cp = new ExtConfigurationParser(warnings);

        try {
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            ExtMyBatisGenerator myBatisGenerator = new ExtMyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (IOException e) {
            logger.error("dao层代码生成异常", e);
        } catch (XMLParserException e) {
            logger.error("dao层代码生成异常", e);
        } catch (InvalidConfigurationException e) {
            logger.error("dao层代码生成异常", e);
        } catch (SQLException e) {
            logger.error("dao层代码生成异常", e);
        } catch (InterruptedException e) {
            logger.error("dao层代码生成异常", e);
            Thread.currentThread().interrupt();
        }
        System.out.println("end generator!");
    }
}
