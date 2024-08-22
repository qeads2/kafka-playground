package com.example.kafkaplayground.service

import com.example.kafkaplayground.domain.ItemEntity
import com.example.kafkaplayground.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository,
) {
    fun createItem(name: String, stock: Int) {
        itemRepository.save(
            ItemEntity(
                name = name,
                stock = stock,
            ),
        )
    }

    fun decreaseStock(itemId: Int) {
        val item = itemRepository.findById(itemId).get()
        item.decreaseStock()
        itemRepository.save(item)
    }
}
