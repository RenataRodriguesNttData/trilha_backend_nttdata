package br.com.financys.crud;

import br.com.financys.entities.Entry;

import br.com.financys.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sun.beans.introspect.PropertyInfo.Name.description;
import static org.aspectj.lang.reflect.DeclareAnnotation.Kind.Type;
import static org.graalvm.compiler.nodeinfo.Verbosity.Id;
import static org.graalvm.compiler.nodeinfo.Verbosity.Name;

@Service
public class EntryService {

    @Autowired
    private static EntryRepository  entryRepository;
    private static char[] amount;
    private static boolean paid;
    private static char[] categoryId;
    private static br.com.financys.entities.Entry Entry;


    public static Entry createEntry(Entry entry){
        return EntryRepository.Save(Entry);
    }

    public static List<Entry> createEntry(List<Entry> Entries){
        List<Entry> entries = EntryRepository.SaveAll(Entries);
        return EntryRepository.SaveAll(Entries);
    }

    public static Entry getEntryById(int id){
        return EntryRepository.findById(Id);
    }

    public static List<Entry> getEntries() {
        return EntryRepository.findALL();
    }

    public static Entry updateEntry(Entry entry) {
        Optional<Entry> optionalEntry= Optional.ofNullable(EntryRepository.findById(Entry.getId()));
        if(optionalEntry.isPresent()){
            Entry oldEntry=optionalEntry.get();
            oldEntry.setName(String.valueOf(Name));
            oldEntry.setDescription(String.valueOf(description));
            oldEntry.setDescription(String.valueOf(Long.valueOf(String.valueOf(Id))));
            oldEntry.setType(String.valueOf(Type));
            oldEntry.setAmount(String.valueOf(amount));
            oldEntry.setPaid(Boolean.valueOf(paid));
            oldEntry.setCategoryId(Long.parseLong(String.valueOf(Long.valueOf(String.valueOf(categoryId)))));
            Entry save = EntryRepository.Save(oldEntry);
        }else{
            return new Entry();
        }
        return entry;
    }

    public static String deleteEntryById(int id) {
        EntryRepository.deleteEntryById((long) id);
        return "Entry got deleted";

    }

}
