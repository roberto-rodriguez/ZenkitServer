/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.dev;

import com.system.dao.PageAccessDAO;
import com.system.dev.backEnd.ControllerGenerator;
import com.system.dev.backEnd.DAOGenerator;
import com.system.dev.backEnd.DTOGenerator;
import com.system.dev.backEnd.ManagerGenerator;
import com.system.dev.backEnd.ModelGenerator;
import com.system.dev.frontEnd.ContainerGenerator;
import com.system.dev.frontEnd.DetailsGenerator;
import com.system.dev.frontEnd.EditorGenerator;
import com.system.dev.frontEnd.GridGenerator;
import com.system.dev.frontEnd.GridTabGenerator;
import com.system.dev.frontEnd.SubPanelGenerator;
import com.system.dev.frontEnd.ViewTabGenerator;
import com.system.dto.request.Hash;
import com.system.manager.PageAccessManager;
import com.system.model.PageAccess;
import com.system.session.DevData;
import com.system.util.IOUtil;
import com.system.util.StringUtil;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author roberto.rodriguez
 */
public class DevExecutor {

    private String path;

    public DevExecutor(String path) {
        this.path = path;
    }

    public List<Hash> generate(Hash request) {
        devData.setUiPck(request.getString("uipck"));
        devData.setEntityName(request.getString("name"));

        request.put("path", path);
        request.put("lowercased_name", StringUtil.lowercaseFirstLetter(request.getString("name")));

        List<Hash> list = Arrays.stream(new SourceGenerator[]{
            containerGenerator,
            detailsGenerator,
            editorGenerator,
            gridGenerator,
            gridTabGenerator,
            subPanelGenerator,
            viewTabGenerator,
            pdfGenerator,
            modelGenerator,
            dtoGenerator,
            daoGenerator,
            managerGenerator,
            controllerGenerator
        }).map(gen -> gen.generate(request)).collect(Collectors.toList());

        return list;
    }

    public void write() throws IOException {
        devData.getData().stream().forEach((fileConfig) -> {
            File file = IOUtil.createFile(fileConfig);
            IOUtil.writeFile(file, fileConfig.getString("src").trim());

            String fullName = fileConfig.getString("fullName");

            if (fullName.endsWith("jrxml")) {
                pdfGenerator.compileReportToFile(fileConfig, file);
            }

            if (fullName.contains("Container")) {
                String entity = devData.getEntityName();
                PageAccess pageAccess = new PageAccess();
                pageAccess.setIdPage(entity.toLowerCase() + "s");
                pageAccess.setNombre(StringUtil.camelCaseToSpaceCapitalized(entity));
                pageAccessManager.saveOrUpdate(pageAccess);
            }
        });
    }

    public void revert() throws IOException {
        devData.getData().stream()
                .filter(fileConfig -> fileConfig.getString("name").endsWith("java"))
                .forEach((fileConfig) -> {
                    File file = IOUtil.createFile(fileConfig);

                    if (file.exists()) {
                        file.delete();
                    }
                });

        pageAccessManager.deleteRecursivelly(devData.getEntityName() + "s");

        String uiPath = path + "/LegoTrackerAMS/src/main/webapp/app/" + devData.getUiPck().replaceAll("\\.", "/") + "/" + StringUtil.lowercaseFirstLetter(devData.getEntityName());
        IOUtil.deleteRecursively(uiPath);

    }

    public List<String> getUIFolders() {
        File file = new File(path + "/LegoTrackerAMS/src/main/webapp/app/view");
        List<String> list = Stream.of(file.listFiles()).map(f -> "view." + f.getName()).collect(Collectors.toList());

        list.add(0, "view");
        return list;
    }

    @Autowired
    protected DevData devData;

    @Autowired
    protected PageAccessManager pageAccessManager;

    @Autowired
    private ModelGenerator modelGenerator;

    @Autowired
    private DTOGenerator dtoGenerator;

    @Autowired
    private DAOGenerator daoGenerator;

    @Autowired
    private ManagerGenerator managerGenerator;

    @Autowired
    private ControllerGenerator controllerGenerator;

    @Autowired
    private ContainerGenerator containerGenerator;

    @Autowired
    private DetailsGenerator detailsGenerator;

    @Autowired
    private EditorGenerator editorGenerator;

    @Autowired
    private GridGenerator gridGenerator;

    @Autowired
    private GridTabGenerator gridTabGenerator;

    @Autowired
    private SubPanelGenerator subPanelGenerator;

    @Autowired
    private ViewTabGenerator viewTabGenerator;

    @Autowired
    private PDFGenerator pdfGenerator;

}
