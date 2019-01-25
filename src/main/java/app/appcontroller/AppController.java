package app.appcontroller;

import app.entity.CompPart;
import app.service.CompPartsService;
import org.apache.log4j.Logger;
import org.springframework.beans.support.PagedListHolder;



import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {
    private static final Logger log = Logger.getLogger(AppController.class);
    private final CompPartsService compPartsService;

    @Autowired
    public AppController(CompPartsService service) {
        this.compPartsService = service;

    }

    @RequestMapping("/")
    public ModelAndView listOfParts(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("main");
        List<CompPart> compParts = compPartsService.getCompParts();
        log.info("Show all components");
        return paging(modelAndView, compParts,  page);
    }

    @RequestMapping("createCompPart")
    public ModelAndView createCompPart(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("NewCompPartObject", new CompPart("",true,0));
        log.info("Creating NewCompPart");
        modelAndView.setViewName("newcomppart");
        return modelAndView;}




    @RequestMapping("editCompPart")
    public ModelAndView editCompPart(@RequestParam int id, @ModelAttribute CompPart compPart) {
        compPart = compPartsService.getCompPart(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("NewCompPartObject", compPart);
        log.info("CompPart Update on Id "+id);
        modelAndView.setViewName("newcomppart");
        return modelAndView;
    }

    @RequestMapping("saveCompPart")
    public ModelAndView saveCompPart(@ModelAttribute CompPart compPart) {
        if(compPart.getId() == 0){
            compPartsService.createCompPart(compPart);
        } else {
            compPartsService.updateCompPart(compPart);
        }
        log.info("CompPart Save: "+compPart);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("deleteCompPart")
    public ModelAndView deleteCompPart(@RequestParam int id)
    {
        compPartsService.deleteCompPart(id);
        log.info("CompPart Delete: " + id);
        return new ModelAndView("redirect:/");
    }



    @RequestMapping("getAllCompParts")
    public ModelAndView getAllParts(){
        List<CompPart> partList = compPartsService.getCompParts();
        ModelAndView modelAndView = new ModelAndView("main", "listcompparts", partList);
        modelAndView.addObject("computers", compPartsService.computersAssembled());
        log.info("CompParts All Upload.");
        return modelAndView;
    }

    @RequestMapping("searchCompPart")
    public ModelAndView searchPart(@RequestParam("searchDescription") String searchDescription){
        List<CompPart> partsList = compPartsService.getCompParts(searchDescription);
        ModelAndView modelAndView = new ModelAndView("main", "listcompparts", partsList);
        modelAndView.addObject("computers", compPartsService.computersAssembled());
        log.info("CompParts search on Descriptions: "+searchDescription);
        return modelAndView;
    }

    @RequestMapping("searchRequired")
    public ModelAndView searchRequired(@RequestParam("requirement") String requirement) {
        List<CompPart> requiredList = compPartsService.getRequired(requirement);
        ModelAndView modelAndView = new ModelAndView("main", "listcompparts", requiredList);
        modelAndView.addObject("computers", compPartsService.computersAssembled());
        log.info("Search with requirement param: " +requirement);
        return modelAndView;
    }

    private ModelAndView paging (ModelAndView modelAndView,List<CompPart> compParts, Integer page ){

        PagedListHolder<CompPart> pagedListHolder = new PagedListHolder<>(compParts);
        pagedListHolder.setPageSize(10);

        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            page=1;
            pagedListHolder.setPage(0);
            modelAndView.addObject("listcompparts", pagedListHolder.getPageList());
        }

        if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("listcompparts", pagedListHolder.getPageList());
        }

        modelAndView.addObject("page", page);
        modelAndView.addObject("computers", compPartsService.computersAssembled());

        return modelAndView;
    }


}
