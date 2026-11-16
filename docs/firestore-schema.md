# Firestore Schema (Planned)

- `users/{uid}`: uid, firstName, lastName, fullName, email, phone, phoneVerified, emailVerified, university, faculty, specialty, educationLevel, profilePhotoUrl, profilePhotoPath, role, preferredLanguage, theme, accountStatus, fcmTokens, createdAt, updatedAt, lastActiveAt
- `categories/{categoryId}`: localized name fields, slug, icon, order, isActive
- `services/{serviceId}`: name, categoryId, description, imageUrl/icon, pricingType, priceAmount, priceUnit, currency, estimatedCompletion, requirements, availabilityStatus, languages[], createdAt, updatedAt
- `orders/{orderId}`: orderId, customerId, customerName, serviceId, serviceName, topic, university, faculty, specialty, educationLevel, language, pageCount, deadlineAt, requirementsText, attachments[], completedFiles[], price, currency, status, adminNotes, createdAt, updatedAt
- `orders/{orderId}/history/{entryId}`: fromStatus, toStatus, changedBy, reason, timestamp
- `conversations/{conversationId}`: type, customerId, customerName, customerPhotoUrl, participantIds[], lastMessage, lastMessageAt, unreadCounts, orderId?, createdAt, updatedAt
- `conversations/{conversationId}/messages/{messageId}`: conversationId, senderId, senderRole, type, text, attachments[], createdAt, readBy/readAt
- `users/{uid}/notifications/{notificationId}`: type, title, body, data/deepLink, isRead, createdAt, sourceRef
- `announcements/{announcementId}`: title, body, isPublished, target, createdBy, createdAt, updatedAt
- `stories/{storyId}`: mediaType, mediaUrl, mediaPath, text, expiresAt, isPublished, createdBy, createdAt
- `reviews/{reviewId}`: customerId, orderId?, rating, comment, isVisible, createdAt
- `settings/{doc}`: controlled configuration
- `auditLogs/{logId}`: actorId, actorRole, action, targetCollection, targetId, details, timestamp (server-written)

Use pagination, composite indexes, and avoid unbounded arrays for high-churn data.
