package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Book;

//@SpringBootTest
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
public class BookControllerTest {
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	public void testAddAndRemoveBook() throws Exception{
//		Book newBook = new Book();
//		newBook.setTitle("TitotloProva");
//		newBook.setAuthor("AutoreProva");
//		newBook.setPublishyear(2023);
//		
//		mockMvc.perform(post("/books")
//				.contentType(MediaType.Application_JSON)
//				.content(new ObjectMapper().writeValueAsString(newBook)))
//				.andExpect(status().isOk());
//		
//		mockMvc.perform(get("/books/1")).andExpect(status.isOk()).andExpect(jsonPath("$.title", is("TitotloProva")));
//	}
}
